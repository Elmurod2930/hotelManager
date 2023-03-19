package org.example.controller;

import org.example.service.TypeService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeTypeController {
    @Autowired
    private TypeService typeService;
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
    public void add(){
        System.out.print("Enter name: ");
        String name=ScannerUtil.scannerText.next();
        typeService.add(name);
    }
    public void list(){
        typeService.getList();
    }
    public void delete(){
        System.out.print("Enter id: ");
        Integer id=ScannerUtil.scannerInt.nextInt();
        typeService.delete(id);
    }
}
