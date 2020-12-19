package com.dsms.db.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dsms.db.entity.OrderEntity;
import com.dsms.db.entity.UserEntity;

/**
 *
 * @author Mahaj
 */
@Repository
public interface OrderRepository extends PagingAndSortingRepository<OrderEntity, String> {

	Page<OrderEntity> findAllByUserEntity(UserEntity userEntity, Pageable pageable);
}
