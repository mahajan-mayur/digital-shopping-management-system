package com.dsms.db.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dsms.db.entity.ItemEntity;
import com.dsms.db.entity.UserEntity;
import com.dsms.db.entity.WishlistItem;

/**
 *
 * @author Mahaj
 */
@Repository
public interface WishlistItemRepository extends PagingAndSortingRepository<WishlistItem, String> {


	List<WishlistItem> findAllByUserEntity(UserEntity userEntity);
	
	WishlistItem findByUserEntityAndItemEntity(UserEntity userEntity, ItemEntity itemEntity);
}
