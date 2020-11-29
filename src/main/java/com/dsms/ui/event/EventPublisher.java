/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.ui.event;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mahaj
 * @param <L>
 * @param <E>
 */
public class EventPublisher<L extends CustomEventListner, E extends EventObject> {

    private final List<L> eventListners;

    public EventPublisher() {
        this.eventListners = new ArrayList<>();
    }

    public EventPublisher(List<L> eventListners) {
        this.eventListners = new ArrayList<>(eventListners);
    }

    public void addEventListner(L eventListner) {
        eventListners.add(eventListner);
    }

    public void publishEvent(E eventObject) {
        eventListners.parallelStream().forEach(eventListner -> eventListner.onEvent(eventObject));
    }

   
}
