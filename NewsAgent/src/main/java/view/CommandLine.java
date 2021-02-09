package view;

import controller.CustomerController;
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

    public int showInterface() {
        System.out.println("\nWelcome to NewsAgent System, сhoose one of the modules:" +
                "\n1 - Customer      | 2 - Employee     | 3 - Publication" +
                "\n4 - Order         | 5 - Bill");
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

    public void start() {
        while (true) {
            switch (showInterface()) {
                case 1:
                    chooseCustomerAction();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }
    }

}
