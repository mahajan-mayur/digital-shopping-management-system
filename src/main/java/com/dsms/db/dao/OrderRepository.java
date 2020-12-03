package com.dsms.db.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dsms.db.entity.OrderEntity;

/**
 *
 * @author Mahaj
 */
@Repository
public interface OrderRepository extends PagingAndSortingRepository<OrderEntity, String> {


}
