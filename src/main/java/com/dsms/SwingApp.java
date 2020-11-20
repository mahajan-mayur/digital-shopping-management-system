package com.dsms;

import com.dsms.ui.MainFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import java.awt.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SwingApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(SwingApp.class)
                .headless(false).run(args);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            log.error("error while Setting look and feel, {}", ex);
        }
        EventQueue.invokeLater(() -> {
            MainFrame mainFrame = ctx.getBean(MainFrame.class);
            mainFrame.setVisible(true);
        });
    }
}
