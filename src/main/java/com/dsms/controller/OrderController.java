/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.controller;

import com.dsms.db.dao.CartItemRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsms.db.dao.OrderRepository;
import com.dsms.db.entity.CartItem;
import com.dsms.db.entity.OrderEntity;
import com.dsms.db.entity.OrderItem;
import com.dsms.db.entity.UserEntity;
import com.dsms.enums.OrderState;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Mahaj
 */
@Service
@Slf4j
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public OrderEntity createOrder(UserEntity userEntity, String shippingAddress, List<CartItem> cartItems) {
        log.info("creating new Order");
        Set<OrderItem> orderItemSet = cartItems.stream().map(cartItem -> buildOrderItem(cartItem)).collect(Collectors.toSet());
        Double totalPrice = orderItemSet.stream()
                .map(orderItem -> orderItem.getItemCount() * orderItem.getPrice())
                .reduce(Double::sum)
                .orElseThrow(() -> new RuntimeException("InvalidToatlIemPrice"));
        OrderEntity orderEntity = OrderEntity.builder()
                .userEntity(userEntity)
                .shippingAddress(shippingAddress)
                .orderState(OrderState.CREATED)
                .orderItemSet(orderItemSet)
                .price(totalPrice)
                .build();
        OrderEntity savedOrder = orderRepository.save(orderEntity);
        if(savedOrder == null){
            log.info("Error while creating order ");
            throw new RuntimeException("unable to create order");
        }
        cartItemRepository.deleteAll(cartItems);
        return savedOrder;
    }

    private OrderItem buildOrderItem(CartItem cartItem) {
        return OrderItem.builder()
                .item(cartItem.getItemEntity())
                .itemCount(cartItem.getItemCount())
                .price(cartItem.getItemEntity().getPrice())
                //.orderEntity(orderEntity)
                .build();
    }
}
