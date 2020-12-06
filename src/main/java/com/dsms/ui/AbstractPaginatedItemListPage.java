/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.ui;

import com.dsms.db.entity.ItemEntity;
import com.dsms.ui.components.HomePageItem;
import java.awt.Dimension;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;

/**
 *
 * @author Mahaj
 */
@Slf4j
public abstract class AbstractPaginatedItemListPage extends JPanel {

    protected JPanel contentPanel;
    protected JPanel jPanel1;
    protected JPanel jPanel2;
    protected JPanel pageBtnPane;

    protected Page<ItemEntity> currentItemsPage;

    protected abstract void initPageContent(int pageNo);

    protected final void goToPage(int pageNo) {
        initPageContent(pageNo);
        showContent();
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

    protected void showContent() {
        contentPanel.removeAll();
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
        content.setMaximumSize(contentPanel.getSize());
        content.setSize(contentPanel.getSize());
        List<HomePageItem> itemList = currentItemsPage.stream().map(item -> new HomePageItem(item)).collect(Collectors.toList());
        // itemList.stream().forEach(i -> content.add(i));
        Iterator<HomePageItem> itr = itemList.iterator();
        while (itr.hasNext()) {
            HomePageItem wishListItem = itr.next();
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

}
