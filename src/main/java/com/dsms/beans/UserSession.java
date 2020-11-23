package com.dsms.beans;

import org.springframework.stereotype.Component;

import com.dsms.db.entity.UserEntity;

import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author Mahaj
 */
@Getter
@Setter
@Component
public class UserSession {
    private UserEntity userEntity;
}
