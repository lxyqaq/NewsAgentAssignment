package view;

import controller.EmployeeController;
import controller.PublicationController;
import dao.EmployeeDAOImpl;
import model.Employee;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.util.*;


public class CommandLine {

    private Scanner scanner = new Scanner(System.in);
    private EmployeeController employeeController = new EmployeeController();
    private PublicationController publicationController = new PublicationController();

    public int showInterface() {
        System.out.println("\nWelcome to NewsAgent System, сhoose one of the modules:" +
                "\n1 - Customer     | 2 - Employee    | 3 - Publication" +
                "\n4 - Order         | 5 - Bill");
        return scanner.nextInt();
    }

    public void chooseEmployeeAction() {
        System.out.println("\n1 - Show all Employees  | 2 - Add Employee" +
                "\n3 - Update Employee     | 4 - Delete Employee" +
                "\n5 - Search Employee     | 6 - Exit");
        int action = scanner.nextInt();
        switch (action) {
            case 1:
                employeeController.GetAll();
                chooseEmployeeAction();
            case 2:
                employeeController.Insert();
                chooseEmployeeAction();
            case 3:
                employeeController.Update();
                chooseEmployeeAction();
            case 4:
                employeeController.DeleteById();
                chooseEmployeeAction();
            case 5:
                employeeController.GetEmployeeById();
                chooseEmployeeAction();
            case 6:
                start();
                break;
        }
    }

    public void choosePublicationAction() {
        System.out.println("\n1 - Show all Publications  | 2 - Add Publication" +
                "\n3 - Update Publication     | 4 - Delete Publication" +
                "\n5 - Search Publication     | 6 - Exit");
        int action = scanner.nextInt();
        switch (action) {
            case 1:
                publicationController.GetAll();
                choosePublicationAction();
            case 2:
                publicationController.Insert();
                choosePublicationAction();
            case 3:
                publicationController.Update();
                choosePublicationAction();
            case 4:
                publicationController.DeleteById();
                choosePublicationAction();
            case 5:
                publicationController.GetPublicationById();
                choosePublicationAction();
            case 6:
                start();
                break;
        }
    }

    public void start() {
        while (true) {
            switch (showInterface()) {
                case 1:
                    break;
                case 2:
                    chooseEmployeeAction();
                    break;
                case 3:
                    choosePublicationAction();
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }
    }

}

