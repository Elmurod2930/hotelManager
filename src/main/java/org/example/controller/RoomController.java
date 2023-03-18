package org.example.controller;

import org.example.util.ScannerUtil;
import org.springframework.stereotype.Controller;

@Controller
public class RoomController {
    public void menu() {
        boolean b = true;
        while (b) {
            System.out.println("1 => Add\n2 => List\n3 => Delete\n4 => Update\n5 => Find\n6 => Room convenient\n0 => Exit");
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
                case 4:
                    update();
                    break;
                case 5:find();
                    break;
                case 6:roomConvenient();
                    break;
            }
        }
    }
    public void add(){
        System.out.print("Enter number: ");

    }
    public void list(){}
    public void delete(){}
    public void update(){}
    public void find(){}
    public void roomConvenient(){}
}
