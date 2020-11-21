/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.db.entity;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Mahaj
 */
@Entity
@Table(name = "OrderItem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem extends TimestampedEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "orderId", foreignKey = @ForeignKey(name = "fk_orderItem_orders_id", value = ConstraintMode.CONSTRAINT), nullable = false, referencedColumnName = "id")
    private OrderEntity orderEntity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "itemId", foreignKey = @ForeignKey(name = "fk_orderItem_item_id", value = ConstraintMode.CONSTRAINT), nullable = false, referencedColumnName = "id")
    private ItemEntity item;

    @Column(name = "itemCount", nullable = false)
    private Integer itemCount;
    
    @Column(name = "price", nullable = false)
    private Double price;
    

}
