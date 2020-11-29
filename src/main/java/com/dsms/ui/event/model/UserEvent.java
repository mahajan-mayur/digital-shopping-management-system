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
public class UserEvent extends EventObject {
    
    private EventType eventType;
    
    public UserEvent(Object o) {
        super(o);
    }

    public UserEvent(Object o, EventType eventType) {
        super(o);
        this.eventType = eventType;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
    
    public static enum EventType{
        LOGIN,LOGOUT
    }
}
