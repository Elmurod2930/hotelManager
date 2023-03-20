package org.example.controller;

import org.example.service.ConvenientService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ConvenientController {
    @Autowired
    private ConvenientService convenientService;

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

    public void add() {
        System.out.print("Enter name: ");
        String name = ScannerUtil.scannerText.next();
        convenientService.add(name);
    }

    public void list() {
        convenientService.getList();
    }

    public void delete() {
        System.out.print("Enter id: ");
        Integer id=ScannerUtil.scannerInt.nextInt();
        convenientService.delete(id);
    }
}
