/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.db.entity;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "cartItem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem extends TimestampedEntity {


    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "itemId", foreignKey = @ForeignKey(name = "fk_cartItem_item_id", value = ConstraintMode.CONSTRAINT), nullable = false, referencedColumnName = "id")
    private ItemEntity itemEntity;

    @Column(name = "itemCount", nullable = false)  
    private Integer itemCount;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", foreignKey = @ForeignKey(name = "fk_cartItem_user_id", value = ConstraintMode.CONSTRAINT), nullable = false, referencedColumnName = "id")
    private UserEntity userEntity;
}
