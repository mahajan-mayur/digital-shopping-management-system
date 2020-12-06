package com.dsms.db.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dsms.db.entity.CartItem;
import com.dsms.db.entity.ItemEntity;
import com.dsms.db.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Mahaj
 */
@Repository
public interface CartItemRepository extends PagingAndSortingRepository<CartItem, String> {

    List<CartItem> findAllByUserEntity(UserEntity userEntity);

    CartItem findByUserEntityAndItemEntity(UserEntity userEntity, ItemEntity itemEntity);

    Page<CartItem> findAllByUserEntity(UserEntity userEntity, Pageable pageable);

    void deleteByUserEntityAndItemEntity(UserEntity userEntity, ItemEntity itemEntity);
}
