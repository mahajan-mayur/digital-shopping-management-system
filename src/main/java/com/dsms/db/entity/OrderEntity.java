/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.db.entity;

import com.dsms.enums.OrderState;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "orderEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity extends TimestampedEntity implements Serializable {
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "userId", foreignKey = @ForeignKey(name = "fk_order_user_id", value = ConstraintMode.CONSTRAINT), nullable = false, referencedColumnName = "id")
    private UserEntity userEntity;
    
    @OneToMany(mappedBy = "orderEntity")
    private Set<OrderItem> orderItemSet;
    
    @Column(name = "price", nullable = false)
    private Double price;
    
    @Column(name = "orderState", nullable = false)
    private OrderState orderState;
    
    @Column(name = "shippingAddress", nullable = false, columnDefinition = "TEXT")
    private String shippingAddress;
    
}
