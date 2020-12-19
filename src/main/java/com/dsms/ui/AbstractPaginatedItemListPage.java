/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.ui;

import java.awt.Dimension;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.springframework.data.domain.Page;

import com.dsms.db.entity.TimestampedEntity;
import com.dsms.db.entity.ItemEntity;
import com.dsms.ui.components.ItemPane;
import com.dsms.ui.event.ItemListPageRefreshEventListner;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Mahaj
 */
@Slf4j
public abstract class AbstractPaginatedItemListPage extends JPanel {

    protected JPanel contentPanel;

    protected ItemListPageType itemListPageType;
    protected Page<? extends TimestampedEntity> currentItemsPage;
    protected JPanel content;
    protected JScrollPane scrollPanel;

    protected abstract void initPageContent(int pageNo);

    protected final void goToPage(int pageNo) {
        initPageContent(pageNo);
        showContent();
        repaint();
        revalidate();
    }

    protected void nextPage() {
        if (currentItemsPage.hasNext()) {
            goToPage(currentItemsPage.getNumber() + 1);
            return;
        }
        log.error("No Next Page, currentPageNo : {}", currentItemsPage.getNumber());
    }

    protected void previousPage() {
        if (currentItemsPage.hasPrevious()) {
            goToPage(currentItemsPage.getNumber() - 1);
            return;
        }
        log.error("No Prevoius Page, currentPageNo : {}", currentItemsPage.getNumber());
    }

    abstract protected void setPageButtons();

    protected final void setPageButtons(JButton previousBtn, JLabel pageNoLbl, JButton nextBtn) {
        if (currentItemsPage.hasPrevious()) {
            previousBtn.setEnabled(true);
        } else {
            previousBtn.setEnabled(false);
        }
        if (currentItemsPage.hasNext()) {
            nextBtn.setEnabled(true);
        } else {
            nextBtn.setEnabled(false);
        }
        pageNoLbl.setText(String.valueOf(currentItemsPage.getNumber() + 1));
    }

    protected void showContent() {
        contentPanel.removeAll();
        content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
        content.setMaximumSize(contentPanel.getSize());
        content.setSize(contentPanel.getSize());
        List<ItemPane> itemList = currentItemsPage.stream().map(item -> new ItemPane((ItemEntity) item, itemListPageType)).collect(Collectors.toList());
        // itemList.stream().forEach(i -> content.add(i));
        Iterator<ItemPane> itr = itemList.iterator();
        while (itr.hasNext()) {
            ItemPane itemPane = itr.next();
            itemPane.setSize(2048, 350);
            itemPane.setMaximumSize(new Dimension(4058, 450));
            Box box = new Box(BoxLayout.LINE_AXIS);
            box.setAlignmentX(CENTER_ALIGNMENT);
            box.add(Box.createHorizontalGlue());
            box.add(itemPane);
            box.add(Box.createHorizontalGlue());
            content.add(box);
        }
        scrollPanel = new JScrollPane(content, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.getViewport().setSize(contentPanel.getSize());
        contentPanel.add(scrollPanel);
    }

    protected final class ItemListPageRefreshEventListnerImpl implements ItemListPageRefreshEventListner {

        @Override
        public void onEvent(EventObject eventObject) {
            goToPage(currentItemsPage.getNumber());
            setPageButtons();
        }
    }

    public static enum ItemListPageType {
        HOME_PAGE,
        WISHLIST_PAGE,
        CART_PAGE,
        MY_ORDERS_PAGE
    }
}
