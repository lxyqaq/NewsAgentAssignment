package view;

import controller.*;
import dao.CustomerDAOImpl;
import model.Customer;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.util.*;

/**
 * @ClassName CommandLine
 * @Description NewsAgent System CommandLine
 * @Author Xiangyu Liu @Email A00279565@student.ait.ie
 * @Date 2021/2/9 00:43
 * @Version 1.0
 */
public class CommandLine {

    private Scanner scanner = new Scanner(System.in);
    private CustomerController customerController = new CustomerController();
    private EmployeeController employeeController = new EmployeeController();
    private PublicationController publicationController = new PublicationController();
    private OrderController orderController = new OrderController();
    private BillController billController = new BillController();
    private InvoiceController invoiceController = new InvoiceController();

    public int showInterface() {
        System.out.println("\nWelcome to NewsAgent System, сhoose one of the modules:" +
                "\n1 - Customer      | 2 - Employee     | 3 - Publication" +
                "\n4 - Order         | 5 - Bill         | 6 - Invoice");
        return scanner.nextInt();
    }

    public void chooseCustomerAction() {
        System.out.println("\n1 - Show all Customers  | 2 - Add Customer" +
                "\n3 - Update Customer     | 4 - Delete Customer" +
                "\n5 - Search Customer     | 6 - Exit");
        int action = scanner.nextInt();
        switch (action) {
            case 1:
                customerController.GetAll();
                chooseCustomerAction();
            case 2:
                customerController.Insert();
                chooseCustomerAction();
            case 3:
                customerController.Update();
                chooseCustomerAction();
            case 4:
                customerController.DeleteById();
                chooseCustomerAction();
            case 5:
                customerController.GetCustomerById();
                chooseCustomerAction();
            case 6:
                start();
                break;
        }
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

    public void chooseOrderAction() {
        System.out.println("\n1 - Show all Orders  | 2 - Add Order" +
                "\n3 - Update Order     | 4 - Delete Order" +
                "\n5 - Search Order     | 6 - Exit");
        int action = scanner.nextInt();
        switch (action) {
            case 1:
                orderController.GetAll();
                chooseOrderAction();
            case 2:
                orderController.Insert();
                chooseOrderAction();
            case 3:
                orderController.Update();
                chooseOrderAction();
            case 4:
                orderController.DeleteById();
                chooseOrderAction();
            case 5:
                orderController.GetOrderById();
                chooseOrderAction();
            case 6:
                start();
                break;
        }
    }

    public void chooseBillAction() {
        System.out.println("\n1 - Show all Bills  | 2 - Update Bill" +
                "\n3 - Delete Bill     | 4 - Search Bill" +
                "\n5 - Exit");
        int action = scanner.nextInt();
        switch (action) {
            case 1:
                billController.GetAll();
                chooseBillAction();
            case 2:
                billController.Update();
                chooseBillAction();
            case 3:
                billController.DeleteById();
                chooseBillAction();
            case 4:
                billController.GetBillById();
                chooseBillAction();
            case 5:
                start();
                break;
        }
    }

    public void chooseInvoiceAction() {
        System.out.println("\n1 - Show all Invoices  | 2 - Update Invoice" +
                "\n3 - Delete Invoice     | 4 - Search Invoice" +
                "\n5 - Exit");
        int action = scanner.nextInt();
        switch (action) {
            case 1:
                invoiceController.GetAll();
                chooseBillAction();
            case 2:
                invoiceController.Update();
                chooseBillAction();
            case 3:
                invoiceController.DeleteById();
                chooseBillAction();
            case 4:
                invoiceController.GetInvoiceById();
                chooseBillAction();
            case 5:
                start();
                break;
        }
    }

    public void start() {
        while (true) {
            switch (showInterface()) {
                case 1:
                    chooseCustomerAction();
                    break;
                case 2:
                    chooseEmployeeAction();
                    break;
                case 3:
                    choosePublicationAction();
                    break;
                case 4:
                    chooseOrderAction();
                    break;
                case 5:
                    chooseBillAction();
                    break;
                case 6:
                    chooseInvoiceAction();
                    break;
            }
        }
    }

}
