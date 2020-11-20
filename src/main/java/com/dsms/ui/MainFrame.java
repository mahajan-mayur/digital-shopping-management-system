/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.ui;

import com.dsms.ui.event.model.SidePaneEvent;
import com.dsms.ui.event.SidePaneEventListner;
import java.awt.Image;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

/**
 *
 * @author Mahaj
 */
@Component
public class MainFrame extends javax.swing.JFrame {

    private static final Logger log = LoggerFactory.getLogger(MainFrame.class);

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {

    }

    @PostConstruct
    public void init() {
        initComponents();
        addSidePaneEventListner();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidePane = new com.dsms.ui.components.SidePane();
        topPane = new com.dsms.ui.components.TopPane();
        mainPane1 = new com.dsms.ui.components.MainPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shopify!");
        setIconImage(getCustomIconImage());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidePane, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topPane, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPane, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(sidePane, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            log.error("error while Setting look and feel, {}", ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.dsms.ui.components.MainPane mainPane1;
    private com.dsms.ui.components.SidePane sidePane;
    private com.dsms.ui.components.TopPane topPane;
    // End of variables declaration//GEN-END:variables

    public Image getCustomIconImage() {
        try {
            return ImageIO.read(ResourceUtils.getFile("classpath:images/icon/favicon-32x32.png"));
        } catch (IOException e) {
            log.error("Error while setting app icon, {}", e, e.getMessage());
            return null;
        }
    }

    private void addSidePaneEventListner() {
        this.sidePane.addEventListner((SidePaneEvent sidePaneEvent) -> {
            log.info("SidePaneEvent : {}", sidePaneEvent.getEventType());
            switch (sidePaneEvent.getEventType()) {
                case CONTACT_US_BUTTON_CLICK:
                    CONTACTUS contactUs = new CONTACTUS();
                    mainPane1.switchPanel(contactUs);
                    break;
                case ABOUT_US_BUTTON_CLICK:
                    ACCOUNTN accountn = new ACCOUNTN();
                    mainPane1.switchPanel(accountn);
                    break;

            }

            //mainPane.setVisible(true);
        });
    }
}
