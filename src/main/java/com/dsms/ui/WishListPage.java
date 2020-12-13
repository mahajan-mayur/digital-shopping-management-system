/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.ui;



import com.dsms.beans.ContextProvider;
import com.dsms.beans.EventPublisherService;
import com.dsms.controller.UserController;
import com.dsms.controller.WishlistController;
import com.dsms.db.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;


/**
 *
 * @author Mahaj
 */
@Slf4j
public class WishListPage extends AbstractPaginatedItemListPage {

    /**
     * Creates new form HomePage
     */
    public WishListPage() {
        initComponents();
        this.itemListPageType = ItemListPageType.WISHLIST_PAGE;
        EventPublisherService.addEventListner(new ItemListPageRefreshEventListnerImpl());
        goToPage(0);
        setPageButtons(previousPageBtn,pageNoLbl,nextPageBtn);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0));
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        contentPanel = new javax.swing.JPanel();
        pageBtnPane = new javax.swing.JPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        previousPageBtn = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0));
        pageNoLbl = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0));
        nextPageBtn = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(420, 322));
        setPreferredSize(new java.awt.Dimension(420, 322));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 83));
        jPanel2.setMinimumSize(new java.awt.Dimension(287, 83));
        jPanel2.setPreferredSize(new java.awt.Dimension(287, 83));
        jPanel2.setVerifyInputWhenFocusTarget(false);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2.add(filler1);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(64, 43, 100));
        jLabel13.setText("WHISHLIST");
        jPanel2.add(jLabel13);

        add(jPanel2);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        contentPanel.setMaximumSize(new java.awt.Dimension(65534, 32767));
        contentPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        contentPanel.setPreferredSize(new java.awt.Dimension(761, 98));
        contentPanel.setLayout(new javax.swing.BoxLayout(contentPanel, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(contentPanel);

        pageBtnPane.setMaximumSize(new java.awt.Dimension(32767, 29));
        pageBtnPane.setMinimumSize(new java.awt.Dimension(597, 29));
        pageBtnPane.setLayout(new javax.swing.BoxLayout(pageBtnPane, javax.swing.BoxLayout.LINE_AXIS));
        pageBtnPane.add(filler2);

        previousPageBtn.setText("<");
        previousPageBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                previousPageBtnMouseClicked(evt);
            }
        });
        pageBtnPane.add(previousPageBtn);
        pageBtnPane.add(filler4);

        pageNoLbl.setText("1");
        pageBtnPane.add(pageNoLbl);
        pageBtnPane.add(filler3);

        nextPageBtn.setText(">");
        nextPageBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextPageBtnMouseClicked(evt);
            }
        });
        pageBtnPane.add(nextPageBtn);
        pageBtnPane.add(filler5);

        jPanel1.add(pageBtnPane);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void previousPageBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previousPageBtnMouseClicked
        previousPage();
        setPageButtons(previousPageBtn,pageNoLbl,nextPageBtn);
    }//GEN-LAST:event_previousPageBtnMouseClicked

    private void nextPageBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextPageBtnMouseClicked
        nextPage();
        setPageButtons(previousPageBtn,pageNoLbl,nextPageBtn);
    }//GEN-LAST:event_nextPageBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton nextPageBtn;
    private javax.swing.JPanel pageBtnPane;
    private javax.swing.JLabel pageNoLbl;
    private javax.swing.JButton previousPageBtn;
    // End of variables declaration//GEN-END:variables

	@Override
	protected final void initPageContent(int pageNo) {
        WishlistController wishlistController = ContextProvider.getBean(WishlistController.class);
        UserController userController = ContextProvider.getBean(UserController.class);
        UserEntity userEntity = userController.getLoggedInUser();
        this.currentItemsPage = wishlistController.getWishlistedItems(userEntity, pageNo, 10);
		
	}

}
