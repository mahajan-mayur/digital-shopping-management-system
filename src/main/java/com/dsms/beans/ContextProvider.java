/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mahaj
 */
@Service
public class ContextProvider implements ApplicationContextAware {
    
    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ContextProvider.ctx = applicationContext;
    }
    
    public static <T> T getBean(Class<T> beanClass) {
        return ctx.getBean(beanClass);
    }
    
}
