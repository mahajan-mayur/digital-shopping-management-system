/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.db.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Mahaj
 */
@Entity
@Table(name = "wishlist")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class WishList extends TimestampedEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, optional = false, targetEntity = User.class)
    @JoinColumn(name = "userId", foreignKey = @ForeignKey(name = "fk_wishlist_user_id", value = ConstraintMode.CONSTRAINT), nullable = false, table = "user", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "wishlist", fetch = FetchType.LAZY, targetEntity = Item.class)
    @JoinColumn(name = "itemId", foreignKey = @ForeignKey(name = "fk_wishlist_item_id", value = ConstraintMode.CONSTRAINT), nullable = false, table = "item", referencedColumnName = "id")
    private Set<Item> items;

}
