/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.beans;

import com.dsms.ui.event.CategoryEventListner;
import com.dsms.ui.event.CustomEventListner;
import com.dsms.ui.event.EventPublisher;
import com.dsms.ui.event.NavigateEventListner;
import com.dsms.ui.event.UserEventListner;
import com.dsms.ui.event.model.CategoryEvent;
import com.dsms.ui.event.model.NavigateEvent;
import com.dsms.ui.event.model.UserActionEvent;
import java.util.EventObject;

/**
 *
 * @author Mahaj
 */
public class EventPublisherService {

    private static final EventPublisher<NavigateEventListner, NavigateEvent> NAVIGATE_EVENT_PUBLISHER;
    private static final EventPublisher<UserEventListner, UserActionEvent> USER_EVENT_PUBLISHER;
    
    private static final EventPublisher<CategoryEventListner, CategoryEvent>  CATEGORY_EVENT_PUBLISHER;

    static {
        NAVIGATE_EVENT_PUBLISHER = new EventPublisher<>();
        USER_EVENT_PUBLISHER = new EventPublisher<>();
        CATEGORY_EVENT_PUBLISHER = new EventPublisher<>();
    }

    public static void addEventListner(CustomEventListner<?> eventListner) {
        if (eventListner instanceof NavigateEventListner) {
            NAVIGATE_EVENT_PUBLISHER.addEventListner((NavigateEventListner) eventListner);
        } else if (eventListner instanceof UserEventListner) {
            USER_EVENT_PUBLISHER.addEventListner((UserEventListner) eventListner);
        } else if (eventListner instanceof CategoryEventListner) {
        	CATEGORY_EVENT_PUBLISHER.addEventListner((CategoryEventListner)eventListner);
        }
    }

    public static void publishEvent(EventObject eventObject) {
        if (eventObject instanceof NavigateEvent) {
            NAVIGATE_EVENT_PUBLISHER.publishEvent((NavigateEvent) eventObject);
        } else if (eventObject instanceof UserActionEvent) {
            USER_EVENT_PUBLISHER.publishEvent((UserActionEvent) eventObject);
        } else if (eventObject instanceof CategoryEvent) {
        	CATEGORY_EVENT_PUBLISHER.publishEvent((CategoryEvent) eventObject);
        }
    }
}
