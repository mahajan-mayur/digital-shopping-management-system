package com.dsms.controller;

import com.dsms.beans.ContextProvider;
import com.dsms.dto.ControllerResponse;
import com.dsms.beans.UserSession;
import com.dsms.db.dao.UserRepository;
import com.dsms.db.entity.UserEntity;
import com.dsms.ui.event.model.LoginEvent;
import com.dsms.ui.event.model.SignUpEvent;

/**
 *
 * @author Mahaj
 */
public class UserController {

    private final UserRepository userRepository;

    public UserController() {
        userRepository = ContextProvider.getBean(UserRepository.class);
    }

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
        UserSession userSession = ContextProvider.getBean(UserSession.class);
        userSession.setUserEntity(userEntity);
        return ControllerResponse.builder().message("Login Success !!").statusCode(ControllerResponse.StatusCode.SUCCESS).build();
    }
}
