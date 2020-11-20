/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.ui.event;

import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Mahaj
 * @param <L>
 * @param <E>
 */
public interface EventPublisher<L extends EventListener, E extends EventObject> {

    void addEventListner(L eventListner);

    void publishEvent(E eventObject);
}
