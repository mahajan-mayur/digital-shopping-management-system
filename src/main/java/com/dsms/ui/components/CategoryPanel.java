/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.ui.components;

import java.awt.Color;

import javax.swing.JPanel;

import com.dsms.beans.EventPublisherService;
import com.dsms.enums.ItemCategory;
import com.dsms.ui.event.model.CategoryEvent;

/**
 *
 * @author Mahaj
 */
public class CategoryPanel extends javax.swing.JPanel {
    
    private JPanel selectedCategoryPanel;

    /**
     * Creates new form CategoryPanel
     */
    public CategoryPanel() {
        initComponents();
        selectedCategoryPanel = this.clothesCategoryPanel;
        selectedCategoryPanel.setBackground(new Color(68, 138, 255));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        clothesCategoryPanel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        shoesCategoryPanel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        groceryCategoryPanel = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        electronicsCategoryPanel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(110, 89, 222));
        jPanel1.setMaximumSize(new java.awt.Dimension(131068, 117));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        clothesCategoryPanel.setBackground(new java.awt.Color(48, 63, 159));
        clothesCategoryPanel.setMaximumSize(new java.awt.Dimension(32767, 117));
        clothesCategoryPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clothesCategoryPanelMouseClicked(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Clothes");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-t-shirt-50.png"))); // NOI18N

        javax.swing.GroupLayout clothesCategoryPanelLayout = new javax.swing.GroupLayout(clothesCategoryPanel);
        clothesCategoryPanel.setLayout(clothesCategoryPanelLayout);
        clothesCategoryPanelLayout.setHorizontalGroup(
            clothesCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clothesCategoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clothesCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addGroup(clothesCategoryPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );
        clothesCategoryPanelLayout.setVerticalGroup(
            clothesCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clothesCategoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(clothesCategoryPanel);

        shoesCategoryPanel.setBackground(new java.awt.Color(48, 63, 159));
        shoesCategoryPanel.setMaximumSize(new java.awt.Dimension(32767, 117));
        shoesCategoryPanel.setPreferredSize(new java.awt.Dimension(205, 93));
        shoesCategoryPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shoesCategoryPanelMouseClicked(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Shoes");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-sneakers-50.png"))); // NOI18N

        javax.swing.GroupLayout shoesCategoryPanelLayout = new javax.swing.GroupLayout(shoesCategoryPanel);
        shoesCategoryPanel.setLayout(shoesCategoryPanelLayout);
        shoesCategoryPanelLayout.setHorizontalGroup(
            shoesCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shoesCategoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(shoesCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        shoesCategoryPanelLayout.setVerticalGroup(
            shoesCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shoesCategoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap())
        );

        jPanel1.add(shoesCategoryPanel);

        groceryCategoryPanel.setBackground(new java.awt.Color(48, 63, 159));
        groceryCategoryPanel.setMaximumSize(new java.awt.Dimension(32767, 117));
        groceryCategoryPanel.setPreferredSize(new java.awt.Dimension(205, 93));
        groceryCategoryPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                groceryCategoryPanelMouseClicked(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Groceries");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-grocery-shelf-50.png"))); // NOI18N

        javax.swing.GroupLayout groceryCategoryPanelLayout = new javax.swing.GroupLayout(groceryCategoryPanel);
        groceryCategoryPanel.setLayout(groceryCategoryPanelLayout);
        groceryCategoryPanelLayout.setHorizontalGroup(
            groceryCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groceryCategoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(groceryCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(groceryCategoryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addGroup(groceryCategoryPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))
                .addContainerGap())
        );
        groceryCategoryPanelLayout.setVerticalGroup(
            groceryCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groceryCategoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(groceryCategoryPanel);

        electronicsCategoryPanel.setBackground(new java.awt.Color(48, 63, 159));
        electronicsCategoryPanel.setMaximumSize(new java.awt.Dimension(32767, 117));
        electronicsCategoryPanel.setPreferredSize(new java.awt.Dimension(205, 93));
        electronicsCategoryPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                electronicsCategoryPanelMouseClicked(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-multiple-devices-50.png"))); // NOI18N

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Electronics");

        javax.swing.GroupLayout electronicsCategoryPanelLayout = new javax.swing.GroupLayout(electronicsCategoryPanel);
        electronicsCategoryPanel.setLayout(electronicsCategoryPanelLayout);
        electronicsCategoryPanelLayout.setHorizontalGroup(
            electronicsCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(electronicsCategoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(electronicsCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(electronicsCategoryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        electronicsCategoryPanelLayout.setVerticalGroup(
            electronicsCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(electronicsCategoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(electronicsCategoryPanel);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void clothesCategoryPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clothesCategoryPanelMouseClicked
        updateSelectedCategory((JPanel) evt.getSource(), ItemCategory.GARMENTS);
    }//GEN-LAST:event_clothesCategoryPanelMouseClicked

    private void shoesCategoryPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shoesCategoryPanelMouseClicked
    	updateSelectedCategory((JPanel) evt.getSource(), ItemCategory.SHOES);
    }//GEN-LAST:event_shoesCategoryPanelMouseClicked

    private void groceryCategoryPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groceryCategoryPanelMouseClicked
    	updateSelectedCategory((JPanel) evt.getSource(), ItemCategory.GROCERY);
    }//GEN-LAST:event_groceryCategoryPanelMouseClicked

    private void electronicsCategoryPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_electronicsCategoryPanelMouseClicked
    	updateSelectedCategory((JPanel) evt.getSource(), ItemCategory.ELECTRONICS);
    }//GEN-LAST:event_electronicsCategoryPanelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel clothesCategoryPanel;
    private javax.swing.JPanel electronicsCategoryPanel;
    private javax.swing.JPanel groceryCategoryPanel;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel shoesCategoryPanel;
    // End of variables declaration//GEN-END:variables

    private void updateSelectedCategory(JPanel selectedJpanel, ItemCategory itemCategory) {
    	selectedCategoryPanel.setBackground(new Color(48,63,159));
    	selectedJpanel.setBackground(new Color(68, 138, 255));
    	selectedCategoryPanel = selectedJpanel;
    	EventPublisherService.publishEvent(new  CategoryEvent(selectedJpanel, itemCategory));
    	repaint();
    	revalidate();
    	
    }
}
