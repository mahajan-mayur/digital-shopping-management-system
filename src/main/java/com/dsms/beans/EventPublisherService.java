/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.beans;

import com.dsms.ui.event.CustomEventListner;
import com.dsms.ui.event.EventPublisher;
import com.dsms.ui.event.NavigateEventListner;
import com.dsms.ui.event.UserEventListner;
import com.dsms.ui.event.model.NavigateEvent;
import com.dsms.ui.event.model.UserEvent;
import java.util.EventObject;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mahaj
 */
@Service
public class EventPublisherService {

    private final EventPublisher<NavigateEventListner, NavigateEvent> navigateEventPublisher;
    private final EventPublisher<UserEventListner, UserEvent> userEventPublisher;

    public EventPublisherService() {

        this.navigateEventPublisher = new EventPublisher<>();
        this.userEventPublisher = new EventPublisher<>();
    }

    public void addEventListner(CustomEventListner eventListner) {
        if (eventListner instanceof NavigateEventListner) {
            navigateEventPublisher.addEventListner((NavigateEventListner) eventListner);
        } else if (eventListner instanceof UserEventListner) {
            userEventPublisher.addEventListner((UserEventListner) eventListner);
        }
    }

    public void publishEvent(EventObject eventObject) {
        if (eventObject instanceof NavigateEvent) {
            navigateEventPublisher.publishEvent((NavigateEvent) eventObject);
        } else if (eventObject instanceof UserEvent) {
            userEventPublisher.publishEvent((UserEvent) eventObject);
        }
    }
}
