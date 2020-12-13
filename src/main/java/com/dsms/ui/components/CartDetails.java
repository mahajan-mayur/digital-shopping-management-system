/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.ui.components;


import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Mahaj
 */
@Slf4j
public class CartDetails extends javax.swing.JPanel {

    public CartDetails() {
        initComponents();
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
        setMaximumSize(new java.awt.Dimension(65534, 32767));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(786, 246));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));
        add(cartReviewPanel);

        buttenPanel.setMaximumSize(new java.awt.Dimension(32862, 23));
        buttenPanel.setLayout(new javax.swing.BoxLayout(buttenPanel, javax.swing.BoxLayout.LINE_AXIS));
        buttenPanel.add(filler1);

        orderNowBtn.setText("Order Now");
        buttenPanel.add(orderNowBtn);
        buttenPanel.add(filler2);

        add(buttenPanel);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttenPanel;
    private javax.swing.JPanel cartReviewPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton orderNowBtn;
    // End of variables declaration//GEN-END:variables
}