/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.ui.event;

import com.dsms.ui.event.model.SidePaneEvent;
import java.util.EventListener;

/**
 *
 * @author Mahaj
 */
public interface SidePaneEventListner extends EventListener {

    void sidePaneEventOccured(SidePaneEvent sidePaneEvent);
}