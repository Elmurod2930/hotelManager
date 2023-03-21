package org.example.controller;

import org.example.service.EmployeeService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AdminController adminController;

    public void menu() {
        boolean b = true;
        while (b) {
            System.out.println("1 => Login\n2 => Complain\n0 => Exit");
            System.out.print("Enter action: ");
            int action = ScannerUtil.scannerInt.nextInt();
            switch (action) {
                case 1:
                    login();
                    break;
                case 2:
                    break;
                case 0:
                    b = false;
                    break;
            }
        }
    }

    public void login() {
        System.out.print("Enter phone: ");
        String phone = ScannerUtil.scannerText.next();
        if (employeeService.login(phone)) {
            adminController.adminMenu();
        }
    }
}
