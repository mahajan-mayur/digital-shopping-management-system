package com.dsms.ui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.kordamp.ikonli.swing.FontIcon;

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

    public ColorBackgroundIcon(FontIcon icon,
            Color background) {
        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g = bufferedImage.createGraphics();
//        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);

        //g.drawImage(baseIcon.getImage(), iconWidth*level, 0, null);
        icon.paintIcon(null, bufferedImage.getGraphics(), 0, 0);
        this.image = new ImageIcon(bufferedImage);
        this.background = background;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(background);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
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
