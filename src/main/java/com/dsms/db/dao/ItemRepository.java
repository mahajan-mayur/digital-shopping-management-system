package com.dsms.db.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dsms.db.entity.ItemEntity;
import com.dsms.enums.ItemCategory;

/**
 *
 * @author Mahaj
 */
@Repository
public interface ItemRepository extends PagingAndSortingRepository<ItemEntity, String> {
	
	Page<ItemEntity> findAllByItemCategory(ItemCategory itemCategory, Pageable pageable);

}
