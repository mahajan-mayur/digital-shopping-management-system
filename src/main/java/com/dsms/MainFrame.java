package com.dsms;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

@Component
public class MainFrame extends JFrame {

    @PostConstruct
    private void initUI() {
        setAlwaysOnTop(false);
        setTitle("Shopify!");

        try {
            setIconImage(ImageIO.read(ResourceUtils.getFile("classpath:images/icon/favicon-32x32.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton quitButton = new JButton("Quit");

        quitButton.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        //createLayout(quitButton);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);
        gl.setAutoCreateContainerGaps(true);
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );
    }
}
