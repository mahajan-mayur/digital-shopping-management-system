/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.db.entity;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 *
 * @author Mahaj
 */
@MappedSuperclass
public abstract class TimestampedEntity {
    
    @Column(name = "createdAt", nullable = false)
    private Long createdAt;
    
    @Column(name = "updatedAt", nullable = false)
    private Long updatedAt;
    
    @PrePersist
    public void prePersist(){
        Long currentTimestamp = new  GregorianCalendar(TimeZone.getTimeZone("UTC"), Locale.ROOT).getTimeInMillis()/1000; 
        this.createdAt = currentTimestamp;
        this.updatedAt = currentTimestamp;
    }
    
    @PreUpdate
    public void preUpdate(){
        Long currentTimestamp = new  GregorianCalendar(TimeZone.getTimeZone("UTC"), Locale.ROOT).getTimeInMillis()/1000; 
        this.updatedAt = currentTimestamp;
    }
}
