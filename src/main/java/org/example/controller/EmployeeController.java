package org.example.controller;

import org.example.entity.EmployeeEntity;
import org.example.service.EmployeeService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Date;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

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
        System.out.print("Enter surname: ");
        String surname = ScannerUtil.scannerText.next();
        System.out.print("Enter phone: ");
        String phone = ScannerUtil.scannerText.next();
        System.out.print("Enter birthday: ");
        Date birthday = Date.valueOf(ScannerUtil.scannerText.next());
        System.out.print("Enter type id: ");
        Integer typeId = ScannerUtil.scannerInt.nextInt();
        EmployeeEntity entity=new EmployeeEntity(name,surname,phone,birthday);
        employeeService.add(entity,typeId);
    }

    public void list() {
        employeeService.getList();
    }

    public void delete() {
        System.out.print("Enter id: ");
        Integer id = ScannerUtil.scannerInt.nextInt();
        employeeService.delete(id);
    }
}
