/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.ui;

import com.dsms.beans.ContextProvider;
import com.dsms.beans.EventPublisherService;
import com.dsms.controller.UserController;
import com.dsms.enums.UserType;
import com.dsms.ui.admin.AddItemPage;
import com.dsms.ui.admin.AdminHome;
import com.dsms.ui.event.NavigateEventListner;
import com.dsms.ui.event.model.NavigateEvent;
import java.awt.Image;
import java.io.IOException;
import java.util.EventObject;
import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
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
        NavigateEventListner navigateEventListner = new NavigateEventListnerImpl();
        EventPublisherService.addEventListner(navigateEventListner);
        mainPane1.switchPanel(new LoginPage());
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

    private class NavigateEventListnerImpl implements NavigateEventListner {

        @Override
        public void onEvent(EventObject eventObject) {
            if (!(eventObject instanceof NavigateEvent)) {
                log.info("unknown event");
            }
            NavigateEvent navigateEvent = (NavigateEvent) eventObject;
            log.info("navigateEvent : {}", navigateEvent.getNavigateTo());
            switch (navigateEvent.getNavigateTo()) {
                case CONTACT_US_PAGE:
                    ContactUsPage contactUs = new ContactUsPage();
                    mainPane1.switchPanel(contactUs);
                    break;
                case MY_ACCOUNT_PAGE:
                    MyAccountPage accountn = new MyAccountPage();
                    mainPane1.switchPanel(accountn);
                    break;
                case ABOUT_US_PAGE:
                    AboutUsPage aboutUs = new AboutUsPage();
                    mainPane1.switchPanel(aboutUs);
                    break;
                case HOME_PAGE:
                    UserController userController = ContextProvider.getBean(UserController.class);

                    JPanel homePage = userController.getLoggedInUserType() == UserType.ADMIN ? new AdminHome() : new HomePage();
                    mainPane1.switchPanel(homePage);
                    break;

                case LOGIN_PAGE:
                    LoginPage loginPage = new LoginPage(navigateEvent.getForwordTo());
                    mainPane1.switchPanel(loginPage);
                    break;
                case MY_ORDERS_PAGE:
                    MyOrderPage myOrderPage = new MyOrderPage();
                    mainPane1.switchPanel(myOrderPage);
                    break;
                case WISHLIST_PAGE:
                    WishListPage wishListPage = new WishListPage();
                    mainPane1.switchPanel(wishListPage);
                    break;
                case CART_PAGE:
                    CartPage cartPage = new CartPage();
                    mainPane1.switchPanel(cartPage);
                    break;

                case SIGN_UP_PAGE:
                    SignUpPage signUpPage = new SignUpPage();
                    signUpPage.addEventListner(this);
                    mainPane1.switchPanel(signUpPage);
                    break;

                case FORGOT_PASS_PAGE:
                    ForgotPass forgotPass = new ForgotPass();
                    mainPane1.switchPanel(forgotPass);
                    break;
                case ADD_ITEM_PAGE:
                    AddItemPage addItem = new AddItemPage();
                    mainPane1.switchPanel(addItem);
                    break;

            }

            //mainPane.setVisible(true);
        }
    }
}
