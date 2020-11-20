/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.ui.components;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JButton;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.swing.FontIcon;

/**
 *
 * @author Mahaj
 */
public class SidePaneJbutton extends JButton {

    private Ikon ikon;

    private Color iconBackgroundColor;

    private Color iconColor;

    public SidePaneJbutton() {

    }

    public Ikon getIkon() {
        return ikon;
    }

    public void setIkon(Ikon ikon) {
        this.ikon = ikon;
    }

    public Color getIconBackgroundColor() {
        return iconBackgroundColor;
    }

    public void setIconBackgroundColor(Color iconBackgroundColor) {
        this.iconBackgroundColor = iconBackgroundColor;
    }

    public Color getIconColor() {
        return iconColor;
    }

    public void setIconColor(Color iconColor) {
        this.iconColor = iconColor;
    }

    @Override
    public Icon getIcon() {
        if (this.ikon == null) {
            return super.getIcon();
        }
        if (iconColor != null) {
            return new ColorBackgroundIcon(FontIcon.of(ikon, iconColor), iconBackgroundColor);
        }
        return new ColorBackgroundIcon(FontIcon.of(ikon), iconBackgroundColor);

    }

    @Override
    protected void paintComponent(Graphics g) {
//        if (this.ikon != null) {
//            setIcon(
//                    new ColorBackgroundIcon(FontIcon.of(ikon, iconColor), iconBackgroundColor));
//        }
        super.paintComponent(g);
    }

}
