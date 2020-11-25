/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.dsms.db.dao.ItemRepository;
import com.dsms.db.dao.UserRepository;
import com.dsms.db.entity.ItemEntity;
import com.dsms.db.entity.UserEntity;
import com.dsms.enums.ItemCategory;
import com.dsms.enums.UserType;

/**
 *
 * @author Mahaj
 */
@Component
public class Test {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ItemRepository itemRepository;

	// @PostConstruct
	public void user() {
		userRepository.save(UserEntity.builder().email("yogesh").address("test").password("test").firstName("yogesh")
				.lastName("mahajan").userType(UserType.CUSTOMER).build());

		UserEntity mayur = userRepository.getUserByUserName("mayur");
		userRepository.delete(mayur);
		System.out.println(mayur);
	}

	//@PostConstruct
	public void addItems() {
String imageUrl = "C:\\Users\\Mahaj\\OneDrive\\Documents\\NetBeansProjects\\tetetetet\\mavenproject1\\src\\main\\resources\\images\\Main content\\jacket1.JPEG";
		ItemEntity b[] = {
				ItemEntity.builder().desciption("description A").itemCategory(ItemCategory.GARMENTS).name("A")
						.price(30.4).imageUrl(imageUrl).build(),
				ItemEntity.builder().desciption("description B").itemCategory(ItemCategory.GARMENTS).name("B")
						.price(30.4).imageUrl(imageUrl).build(),
				ItemEntity.builder().desciption("description C").itemCategory(ItemCategory.GARMENTS).name("C")
						.price(30.4).imageUrl(imageUrl).build(),
				ItemEntity.builder().desciption("description D").itemCategory(ItemCategory.GARMENTS).name("D")
						.price(30.4).imageUrl(imageUrl).build(),
				ItemEntity.builder().desciption("description E").itemCategory(ItemCategory.GARMENTS).name("E")
						.price(30.4).imageUrl(imageUrl).build(),
				ItemEntity.builder().desciption("description F").itemCategory(ItemCategory.GARMENTS).name("F")
						.price(30.4).imageUrl(imageUrl).build() };
		itemRepository.saveAll(Arrays.asList(b));

	}

	public static void main(String[] args) throws IOException {

		
		  HttpHeaders headers = new HttpHeaders();
		  headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		  
		  MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		  body.add("file", new
		  FileSystemResource("/C:/Users/Mahaj/Downloads/SL-3 Project.pdf"));
		  
		  HttpEntity<MultiValueMap<String, Object>> requestEntity = new
		  HttpEntity<>(body, headers);
		  
		  String serverUrl = "http://127.0.0.1:8000";
		  
		  
		  
		  RestTemplate restTemplate = new RestTemplate();
		  System.out.println(restTemplate.getForObject(serverUrl, String.class));
		  
		  ResponseEntity<String> response = restTemplate .postForEntity(serverUrl,
		  requestEntity, String.class);
		 

		//OkHttpClient client = new OkHttpClient().newBuilder().build();
		/*
		 * Request request = new Request.Builder() .url("http://localhost:8000")
		 * .method("GET", null) .build(); Response response =
		 * client.newCall(request).execute();
		 * 
		 * System.out.println(response.body().string());
		 */

		
			/*
			 * MediaType mediaType = MediaType.parse("text/plain"); RequestBody body = new
			 * MultipartBody.Builder().setType(MultipartBody.FORM) .addFormDataPart("file",
			 * "SL-3 Project.pdf", RequestBody.create(new
			 * File("/C:/Users/Mahaj/Downloads/SL-3 Project.pdf"),
			 * MediaType.parse("application/octet-stream"))) .build(); Request request = new
			 * Request.Builder().url("http://localhost:8000").method("POST", body).build();
			 * Response response = client.newCall(request).execute();
			 */

	}
}
