package com.dsms.db.dao;

import com.dsms.db.entity.ItemEntity;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.dsms.db.entity.UserEntity;
import com.dsms.enums.ItemCategory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mahaj
 */
@Repository
public interface ItemRepository extends PagingAndSortingRepository<ItemEntity, String> {
	
	Page<ItemEntity> findAllByItemCategory(ItemCategory itemCategory, Pageable pageable);

}
