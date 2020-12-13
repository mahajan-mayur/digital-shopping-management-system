/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.ui.components;

import com.dsms.db.entity.CartItem;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Mahaj
 */
@Slf4j
public class CartDetails extends javax.swing.JPanel {
    
    private List<CartItem> cartItemList;
    
    public CartDetails() {
        initComponents();
    }
    
    public CartDetails(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
        initComponents();
        showContent();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cartReviewPanel = new javax.swing.JPanel();
        buttenPanel = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        orderNowBtn = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0));

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        cartReviewPanel.setLayout(new javax.swing.BoxLayout(cartReviewPanel, javax.swing.BoxLayout.PAGE_AXIS));
        add(cartReviewPanel);

        buttenPanel.setBackground(new java.awt.Color(255, 255, 255));
        buttenPanel.setMaximumSize(new java.awt.Dimension(32862, 23));
        buttenPanel.setLayout(new javax.swing.BoxLayout(buttenPanel, javax.swing.BoxLayout.LINE_AXIS));
        buttenPanel.add(filler1);

        orderNowBtn.setText("Order Now");
        orderNowBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderNowBtnActionPerformed(evt);
            }
        });
        buttenPanel.add(orderNowBtn);
        buttenPanel.add(filler2);

        add(buttenPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void orderNowBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderNowBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderNowBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttenPanel;
    private javax.swing.JPanel cartReviewPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton orderNowBtn;
    // End of variables declaration//GEN-END:variables

    private void showContent() {
        List<CartReviewItemPane> cartReviewItemPanes = new ArrayList<>();
        for (int i = 0; i < this.cartItemList.size(); i++) {
            cartReviewItemPanes.add(new CartReviewItemPane(i+1, cartItemList.get(i)));
        }
        
        Iterator<CartReviewItemPane> itr = cartReviewItemPanes.iterator();
        while (itr.hasNext()) {
            this.cartReviewPanel.add(itr.next());
        }
        
        JSeparator jSeparator = new JSeparator();
        cartReviewPanel.add(jSeparator);
        Box totalBox = Box.createHorizontalBox();
        totalBox.add(Box.createHorizontalGlue());
        totalBox.add(new JLabel("Total = "));
        
        JLabel totalPriceLbl = new JLabel();
        totalPriceLbl.setHorizontalAlignment(SwingConstants.TRAILING);
        totalPriceLbl.setText("90.05");
        totalPriceLbl.setMaximumSize(new Dimension(80, 14));
        totalPriceLbl.setMinimumSize(new Dimension(80, 14));
        totalPriceLbl.setPreferredSize(new Dimension(80, 14));
        totalBox.add(totalPriceLbl);
        totalBox.add(Box.createRigidArea(new Dimension(10, 0)));
        cartReviewPanel.add(totalBox);
    }
}
