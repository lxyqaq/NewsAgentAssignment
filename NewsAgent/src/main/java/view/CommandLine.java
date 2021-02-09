package view;

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
    private CustomerDAOImpl customerDAO = new CustomerDAOImpl();

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
                testGetAll();
                chooseCustomerAction();
            case 2:
                testInsert();
                chooseCustomerAction();
            case 3:
                testUpdateConnectionCustomer();
                chooseCustomerAction();
            case 4:
                testDeleteById();
                chooseCustomerAction();
            case 5:
                testGetCustomerById();
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

    // CustomerDAO Method:
    public void testInsert() {
        Connection conn = null;
        System.out.printf("Enter Customer Name: \n");
        String customerName = scanner.next();
        System.out.printf("Enter Customer Emali: \n");
        String customerEmail = scanner.next();
        System.out.printf("Enter Customer Address: \n");
        String customerAddress = scanner.next();
        System.out.printf("Enter Customer PhoneNumber: \n");
        String customerPhoneNumber = scanner.next();
        try {
            conn = JDBCUtils.getConnection();
            Customer cust = new Customer(customerName, customerEmail, customerAddress, customerPhoneNumber);
            customerDAO.insert(conn, cust);
            System.out.println("Added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void testDeleteById() {
        Connection conn = null;
        System.out.printf("Enter Customer ID: \n");
        int customerId = scanner.nextInt();
        try {
            conn = JDBCUtils.getConnection();
            customerDAO.deleteById(conn, customerId);
            System.out.println("Successfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void testUpdateConnectionCustomer() {
        Connection conn = null;
        System.out.printf("Enter Customer ID: \n");
        int customerId = scanner.nextInt();
        System.out.printf("Enter Customer Name: \n");
        String customerName = scanner.next();
        System.out.printf("Enter Customer Emali: \n");
        String customerEmail = scanner.next();
        System.out.printf("Enter Customer Address: \n");
        String customerAddress = scanner.next();
        System.out.printf("Enter Customer PhoneNumber: \n");
        String customerPhoneNumber = scanner.next();
        long customerBirth = scanner.nextLong();
        try {
            conn = JDBCUtils.getConnection();
            Customer cust = new Customer(customerId, customerName, customerEmail, customerAddress, customerPhoneNumber);
            customerDAO.update(conn, cust);
            System.out.println("Successfully modified");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void testGetCustomerById() {
        Connection conn = null;
        System.out.printf("Enter Customer ID: \n");
        int customerId = scanner.nextInt();
        try {
            conn = JDBCUtils.getConnection();
            Customer cust = customerDAO.getCustomerById(conn, customerId);
            System.out.println(cust);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void testGetAll() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            List<Customer> list = customerDAO.getAll(conn);
            list.forEach(System.out::println);
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine();
        commandLine.start();
    }

}
