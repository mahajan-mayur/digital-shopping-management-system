package com.dsms.db.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dsms.db.entity.OrderItem;

/**
 *
 * @author Mahaj
 */
@Repository
public interface OrderItemRepository extends PagingAndSortingRepository<OrderItem, String> {

}
