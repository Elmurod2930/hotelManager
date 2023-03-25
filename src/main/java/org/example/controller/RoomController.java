package org.example.controller;

import org.example.entity.RoomEntity;
import org.example.entity.enums.RoomType;
import org.example.service.RoomService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;

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
                case 5:
                    find();
                    break;
                case 6:
                    roomConvenient();
                    break;
            }
        }
    }

    public void add() {
        System.out.print("Enter number: ");
        Integer number = ScannerUtil.scannerInt.nextInt();
        System.out.print("Enter folder: ");
        Integer folder = ScannerUtil.scannerInt.nextInt();
        System.out.print("Enter type: ");
        String type = ScannerUtil.scannerText.next();
        System.out.print("Enter price: ");
        Double price = ScannerUtil.scannerDouble.nextDouble();
        System.out.print("Enter area: ");
        Double area = ScannerUtil.scannerDouble.nextDouble();
        RoomEntity entity = new RoomEntity(number, folder, RoomType.valueOf(type), area, price);
        roomService.add(entity);
    }

    public void list() {
        roomService.list();
    }

    public void delete() {
        System.out.print("Enter id: ");
        Integer id = ScannerUtil.scannerInt.nextInt();
        roomService.delete(id);
    }

    public void update() {
        // TODO: 3/20/2023
    }

    public void find() {
        System.out.print("Enter id: ");
        Integer id = ScannerUtil.scannerInt.nextInt();
        roomService.find(id);
    }

    public void roomConvenient() {
        // TODO: 3/20/2023
    }
}
