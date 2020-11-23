package com.dsms.ui.event.model;

import java.util.EventObject;

import com.dsms.enums.UserType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpEvent extends EventObject {

	private static final long serialVersionUID = -7817011625150819218L;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String password;
	private UserType userType;

	public SignUpEvent(Object source) {
		super(source);
	}

	@Builder
	public SignUpEvent(Object source, String firstName, String lastName, String email, String address, String password,
			UserType userType) {
		super(source);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.password = password;
		this.userType = userType;
	}

}
