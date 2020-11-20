package com.dsms.ui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ColorBackgroundIcon implements Icon {

    private final ImageIcon image;
    private Color background;

    public ColorBackgroundIcon(ImageIcon image,
            Color background) {
        this.image = image;
        this.background = background;
    }

    public ColorBackgroundIcon(String iconFileLocation,
            Color background) {
        this.image = new ImageIcon(getClass().getResource(iconFileLocation));
        this.background = background;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(background);
        g.fillRect(x, y, getIconWidth(), getIconHeight());
        g2d.drawImage(image.getImage(), x, y, null);
    }

    public void setColor(Color bgColor) {
        this.background = bgColor;
    }

    @Override
    public int getIconWidth() {
        return image.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return image.getIconHeight();
    }
}
