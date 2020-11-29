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

    private static final long serialVersionUID = -3929122502212114867L;
    private NavigateTo navigateTo;
    private NavigateTo forwordTo;

    public NavigateEvent(Object o) {
        super(o);
    }

    public NavigateEvent(Object o, NavigateTo navigateTo) {
        super(o);
        this.navigateTo = navigateTo;
    }

    public NavigateEvent(Object o, NavigateTo navigateTo, NavigateTo forwordTo) {
        super(o);
        this.navigateTo = navigateTo;
        this.forwordTo = forwordTo;
    }

    public NavigateTo getNavigateTo() {
        return navigateTo;
    }

    public void setNavigateTo(NavigateTo navigateTo) {
        this.navigateTo = navigateTo;
    }

    public NavigateTo getForwordTo() {
        return forwordTo;
    }

    public void setForwordTo(NavigateTo forwordTo) {
        this.forwordTo = forwordTo;
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
