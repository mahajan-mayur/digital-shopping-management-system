package com.dsms.ui.components;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage image;
    
    

    public ImagePanel(){
       try {                
          image = ImageIO.read(new File(getClass().getResource("/images/CF8CCDF8-823E-4F5A-8246-F844E7DAF5C4.JPEG").toURI()));
       } catch (Exception ex) {
            // handle exception...
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }

}