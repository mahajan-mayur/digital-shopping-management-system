/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.controller;

import com.dsms.db.dao.UserRepository;
import com.dsms.db.entity.UserEntity;
import com.dsms.enums.UserType;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mahaj
 */
//@Component
public class Test {

	@Autowired
	UserRepository userRepository;

	@PostConstruct
	public void test() {
		userRepository.save(UserEntity.builder().email("yogesh").address("test").password("test").firstName("yogesh")
				.lastName("mahajan").userType(UserType.CUSTOMER).build());

		UserEntity mayur = userRepository.getUserByUserName("mayur");
userRepository.delete(mayur);
		System.out.println(mayur);
	}
}
