package com.dsms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsms.beans.UserSession;
import com.dsms.db.dao.UserRepository;
import com.dsms.db.entity.UserEntity;
import com.dsms.dto.ControllerResponse;
import com.dsms.enums.UserType;
import com.dsms.ui.event.model.LoginEvent;
import com.dsms.ui.event.model.SignUpEvent;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Mahaj
 */
@Slf4j
@Service
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSession userSession;

    public Boolean signUp(SignUpEvent signUpEvent) {
        UserEntity user = UserEntity.builder().address(signUpEvent.getAddress())
                .email(signUpEvent.getEmail())
                .firstName(signUpEvent.getFirstName())
                .lastName(signUpEvent.getLastName())
                .password(signUpEvent.getPassword())
                .userType(signUpEvent.getUserType())
                .build();
        UserEntity savedUser = userRepository.save(user);
        return savedUser != null;
    }

    public ControllerResponse login(LoginEvent loginEvent) {
        UserEntity userEntity = userRepository.getUserByUserName(loginEvent.getUserName());
        if (userEntity == null) {
            return ControllerResponse.builder().message("User not Found").statusCode(ControllerResponse.StatusCode.USER_NOT_FOUND).build();
        }
        if (userEntity.getPassword().compareTo(loginEvent.getPassword()) != 0) {
            return ControllerResponse.builder().message("invalid password").statusCode(ControllerResponse.StatusCode.PASSWORD_MISMATCH).build();
        }
        this.userSession.setUserEntity(userEntity);
        log.info("Login Success !!");
        return ControllerResponse.builder().message("Login Success !!").statusCode(ControllerResponse.StatusCode.SUCCESS).build();
    }

    public ControllerResponse logout() {
        this.userSession.clearUserSession();
        log.info("Logout Success !!");
        return ControllerResponse.builder().message("Logout Success !!").statusCode(ControllerResponse.StatusCode.SUCCESS).build();
    }

    public Boolean isUserLoggedIn() {
        return userSession.getUserEntity() != null;
    }

    public UserType getLoggedInUserType() {
        return userSession.getUserEntity() == null ? null : userSession.getUserEntity().getUserType();
    }

    public UserEntity getLoggedInUser() {
        return userSession.getUserEntity();
    }
}
