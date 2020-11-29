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
 * @param <E>
 */
public interface CustomEventListner<E extends EventObject>  extends EventListener{

   void onEvent(E eventObject);
}
