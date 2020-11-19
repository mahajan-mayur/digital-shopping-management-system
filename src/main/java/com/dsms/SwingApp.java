package com.dsms;

import com.dsms.ui.MainFrame1;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import java.awt.*;

@SpringBootApplication
public class SwingApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(SwingApp.class)
                .headless(false).run(args);
        EventQueue.invokeLater(() -> {
            MainFrame1 mainFrame = ctx.getBean(MainFrame1.class);
            mainFrame.setVisible(true);
        });
    }
}
