package com.dsms.db.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.dsms.db.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mahaj
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {

    @Query(value = "SELECT u FROM UserEntity u WHERE u.email = :userName")
    UserEntity getUserByUserName(String userName);

}
