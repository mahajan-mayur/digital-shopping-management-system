/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.ui.event.model;

import java.util.EventObject;

/**
 *
 * @author Mahaj
 */
public class SidePaneEvent extends EventObject {

    private Type eventType;

    public SidePaneEvent(Object o) {
        super(o);
    }

    public SidePaneEvent(Object o, Type eventType) {
        super(o);
        this.eventType = eventType;
    }

    public Type getEventType() {
        return eventType;
    }

    public void setEventType(Type eventType) {
        this.eventType = eventType;
    }

    public static enum Type {
        HOME_BUTTON_CLICK,
        LOGIN_BUTTON_CLICK,
        MY_ACCOUNT_BUTTON_CLICK,
        WISHLIST_BUTTON_CLICK,
        ORDERS_BUTTON_CLICK,
        CONTACT_US_BUTTON_CLICK,
        ABOUT_US_BUTTON_CLICK
        
    };

}
