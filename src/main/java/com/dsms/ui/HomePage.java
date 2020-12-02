/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.ui;

import org.springframework.data.domain.Page;

import com.dsms.beans.ContextProvider;
import com.dsms.beans.EventPublisherService;
import com.dsms.controller.ItemController;
import com.dsms.db.entity.ItemEntity;
import com.dsms.enums.ItemCategory;
import com.dsms.ui.components.WishlistItem;
import com.dsms.ui.event.CategoryEventListner;
import com.dsms.ui.event.model.CategoryEvent;
import java.awt.Dimension;

import lombok.extern.slf4j.Slf4j;

import java.util.EventObject;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Mahaj
 */
@Slf4j
public class HomePage extends javax.swing.JPanel {
    
    private ItemCategory selectedItemCategory;

    /**
     * Creates new form HomePage
     */
    public HomePage() {        
        initComponents();
        CategoryEventListner categoryEventListner = new CategoryEventListnerImpl();
        EventPublisherService.addEventListner(categoryEventListner);
        
        selectedItemCategory = ItemCategory.GARMENTS;
        initContent();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        categoryPanel = new com.dsms.ui.components.CategoryPanel();
        jPanel1 = new javax.swing.JPanel();
        contentPanel = new javax.swing.JPanel();
        pageBtnPane = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(420, 322));
        setPreferredSize(new java.awt.Dimension(420, 322));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        categoryPanel.setMinimumSize(new java.awt.Dimension(287, 83));
        categoryPanel.setPreferredSize(new java.awt.Dimension(287, 83));
        add(categoryPanel);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        contentPanel.setMaximumSize(new java.awt.Dimension(65534, 32767));
        contentPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        contentPanel.setPreferredSize(new java.awt.Dimension(761, 98));
        contentPanel.setLayout(new javax.swing.BoxLayout(contentPanel, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(contentPanel);

        pageBtnPane.setMaximumSize(new java.awt.Dimension(32767, 29));
        pageBtnPane.setMinimumSize(new java.awt.Dimension(597, 29));

        javax.swing.GroupLayout pageBtnPaneLayout = new javax.swing.GroupLayout(pageBtnPane);
        pageBtnPane.setLayout(pageBtnPaneLayout);
        pageBtnPaneLayout.setHorizontalGroup(
            pageBtnPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );
        pageBtnPaneLayout.setVerticalGroup(
            pageBtnPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel1.add(pageBtnPane);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.dsms.ui.components.CategoryPanel categoryPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pageBtnPane;
    // End of variables declaration//GEN-END:variables
    
    private void initContent() {
        contentPanel.removeAll();
        ItemController itemController = ContextProvider.getBean(ItemController.class);
        Page<ItemEntity> page = itemController.getCategoryItems(selectedItemCategory, 0, 200);
        
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
        content.setMaximumSize(contentPanel.getSize());
        content.setSize(contentPanel.getSize());
        
        List<WishlistItem> itemList = page.getContent().stream().map(
                item -> new WishlistItem(item.getImageUrl(), item.getItemCategory(), item.getName(), item.getPrice()))
                .collect(Collectors.toList());

        // itemList.stream().forEach(i -> content.add(i));
        Iterator<WishlistItem> itr = itemList.iterator();
        while (itr.hasNext()) {
            WishlistItem wishListItem = itr.next();
            wishListItem.setSize(2048, 350);
            wishListItem.setMaximumSize(new Dimension(4058, 450));
            Box box = new Box(BoxLayout.LINE_AXIS);
           box.setAlignmentX(CENTER_ALIGNMENT);
          box.add(Box.createHorizontalGlue());
            box.add(wishListItem);
            box.add(Box.createHorizontalGlue());
            content.add(box);
        }
        JScrollPane scrollPanel = new JScrollPane(content, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.getViewport().setSize(contentPanel.getSize());
        contentPanel.add(scrollPanel);
        
    }
    
    private class CategoryEventListnerImpl implements CategoryEventListner {
        
        @Override
        public void onEvent(EventObject eventObject) {
            if (!(eventObject instanceof CategoryEvent)) {
                log.info("invalid event {}", eventObject);
                return;
            }
            CategoryEvent categoryEvent = (CategoryEvent) eventObject;
            
            selectedItemCategory = categoryEvent.getSelectedItemCategory();
            log.info("Category Event selected category : {}", selectedItemCategory);
            initContent();
            repaint();
            revalidate();
            
        }
        
    }
}
