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
public class NavigateEvent extends EventObject {

    private NavigateTo navigateTo;

    public NavigateEvent(Object o) {
        super(o);
    }

    public NavigateEvent(Object o, NavigateTo navigateTo) {
        super(o);
        this.navigateTo = navigateTo;
    }

    public NavigateTo getNavigateTo() {
        return navigateTo;
    }

    public void setNavigateTo(NavigateTo navigateTo) {
        this.navigateTo = navigateTo;
    }

    public static enum NavigateTo {
        HOME_PAGE,
        LOGIN_PAGE,
        SIGN_UP_PAGE,
        FORGOT_PASS_PAGE,
        MY_ACCOUNT_PAGE,
        WISHLIST_PAGE,
        MY_ORDERS_PAGE,
        CONTACT_US_PAGE,
        ABOUT_US_PAGE,
    };

}
