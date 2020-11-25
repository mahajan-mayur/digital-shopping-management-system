/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.db.entity;

import com.dsms.enums.ItemCategory;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "itemEntity")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity extends TimestampedEntity  {

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "desciption", nullable = false)
    private String desciption;
    
    @Column(name = "price", nullable = false)
    private Double price;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "itemCategory", nullable = false)
    private ItemCategory itemCategory;
    
    @Column(name = "imageUrl", nullable = false, columnDefinition = "TEXT")
    private String imageUrl;
}
