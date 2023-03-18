package org.example.controller;

import org.example.util.ScannerUtil;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeTypeController {
    public void menu() {
        boolean b = true;
        while (b) {
            System.out.println("1 => Add\n2 => List\n3 => Delete\n0 => Exit");
            System.out.print("Enter action: ");
            int action = ScannerUtil.scannerInt.nextInt();
            switch (action) {
                case 0:
                    b = false;
                    break;
                case 1:
                    add();
                    break;
                case 2:
                    list();
                    break;
                case 3:
                    delete();
                    break;
            }
        }
    }
    public void add(){}
    public void list(){}
    public void delete(){}
}
