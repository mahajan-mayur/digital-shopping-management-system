/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.db.entity;

import java.io.Serializable;
import javax.persistence.ConstraintMode;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mahaj
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractListItem extends TimestampedEntity implements Serializable {

    @ManyToOne(optional = false)
    @JoinColumn(name = "userId", foreignKey = @ForeignKey(name = "fk_wishlist_user_id", value = ConstraintMode.CONSTRAINT), nullable = false, referencedColumnName = "id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "itemId", foreignKey = @ForeignKey(name = "fk_wishlist_item_id", value = ConstraintMode.CONSTRAINT), nullable = false, referencedColumnName = "id")
    private Item item;

}
