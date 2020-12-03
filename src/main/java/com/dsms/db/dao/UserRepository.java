package com.dsms.db.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.dsms.db.entity.UserEntity;

/**
 *
 * @author Mahaj
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, String> {

    @Query(value = "SELECT u FROM UserEntity u WHERE u.email = :userName")
    UserEntity getUserByUserName(String userName);

}
