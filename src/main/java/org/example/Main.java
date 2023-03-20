package org.example;

import org.example.config.Config;
import org.example.controller.AdminController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        AdminController adminController = (AdminController) applicationContext.getBean("adminController");
        adminController.adminMenu();
    }
}