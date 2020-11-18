package com.dsms.ui;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MainFrame extends JFrame {
    
    private static final Logger log = LoggerFactory.getLogger(MainFrame.class);
    
    @PostConstruct
    private void initUI() {
        setAlwaysOnTop(false);
        setTitle("Shopify!");
        try {
            setIconImage(ImageIO.read(ResourceUtils.getFile("classpath:images/icon/favicon-32x32.png")));
        } catch (IOException e) {
            log.error("Error while setting app icon, {}", e, e.getMessage());
        }
        setSize(990, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
