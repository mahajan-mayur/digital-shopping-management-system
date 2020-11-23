/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.ui.event.model;

import java.util.EventObject;

import com.dsms.enums.UserType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mahaj
 */
@Getter
@Setter
public class LoginEvent extends EventObject {

	private static final long serialVersionUID = -1155144208841928378L;
	public LoginEvent(Object source) {
		super(source);

	}

	@Builder
	public LoginEvent(Object source, String userName, String password, UserType userType) {
		super(source);
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}

	private String userName;
	private String password;
	private UserType userType;

}
