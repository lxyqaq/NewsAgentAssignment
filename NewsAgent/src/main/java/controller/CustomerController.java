package controller;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import model.Customer;
import utils.JDBCUtils;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName CustomerController
 * @Description CustomerController database CRUD method
 * @Author Xiangyu Liu @Email A00279565@student.ait.ie
 * @Date 2021/2/9 18:18
 * @Version 1.0
 */
public class CustomerController {

    private Scanner scanner = new Scanner(System.in);
    private CustomerDAO customerDAO = new CustomerDAOImpl();

    // CustomerDAO Method:
    public void Insert() {
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

    public void DeleteById() {
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

    public void Update() {
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

    public void GetCustomerById() {
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

    public void GetAll() {
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

}
