package org.example.controller;

import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
    @Autowired
    private BookingController bookingController;
    @Autowired
    private ConvenientController convenientController;
    @Autowired
    private EmployeeController employeeController;
    @Autowired
    private EmployeeTypeController employeeTypeController;
    @Autowired
    private GuestController guestController;
    @Autowired
    private OutComeController outComeController;
    @Autowired
    private RoomController roomController;

    public void adminMenu() {
        boolean b = true;
        while (b) {
            System.out.println("1 => Room\n2 => Convenient\n3 => Employee Type\n4 => Employee\n" +
                    "5 => Guest\n6 => Booking\n7 => OutCome\n8 => Tozalandan\n9 => Arznomalar\n0 => Exit");
            System.out.print("Enter action: ");
            int action = ScannerUtil.scannerInt.nextInt();
            switch (action) {
                case 0:
                    b = false;
                    break;
                case 1:
                    roomController.menu();
                    break;
                case 2:
                    convenientController.menu();
                    break;
                case 3:
                    employeeTypeController.menu();
                    break;
                case 4:
                    employeeController.menu();
                    break;
                case 5:
                    guestController.menu();
                    break;
                case 6:
                    bookingController.menu();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }
        }
    }
}
