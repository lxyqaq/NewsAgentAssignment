package controller;

import dao.OrderDAO;
import dao.OrderDAOImpl;
import model.Order;
import utils.JDBCUtils;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/3/14 20:00
 * @Version 1.0
 */
public class OrderController {

    private Scanner scanner = new Scanner(System.in);
    private OrderDAO orderDAO = new OrderDAOImpl();

    // CustomerDAO Method:
    public void Insert() {
        System.out.printf("Enter Customer Name: \n");
        String customerName = scanner.next();
        System.out.printf("Enter Publication Name: \n");
        String publicationName = scanner.next();
        System.out.printf("Enter Date: \n");
        String date = scanner.next();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Order order = new Order(customerName, publicationName, date);
            boolean insert = orderDAO.insert(conn, order);
            if (insert == true) {
                System.out.println("Order Details Saved");
            } else {
                System.out.println("ERROR: Order Details NOT Saved");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void DeleteById() {
        System.out.printf("Enter Order ID: \n");
        int orderId = scanner.nextInt();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            boolean delete = orderDAO.deleteById(conn, orderId);
            if (delete == true) {
                System.out.println("Order Deleted");
            } else {
                System.out.println("ERROR: Order Details NOT Deleted or Do Not Exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void Update() {
        System.out.printf("Enter Order ID: \n");
        int orderId = scanner.nextInt();
        System.out.printf("Enter Customer Name: \n");
        String customerName = scanner.next();
        System.out.printf("Enter Publication Name: \n");
        String publicationName = scanner.next();
        System.out.printf("Enter Date: \n");
        String date = scanner.next();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Order order = new Order(orderId, customerName, publicationName, date);
            boolean update = orderDAO.update(conn, order);
            if (update == true) {
                System.out.println("Order Updated");
            } else {
                System.out.println("ERROR: Order Details NOT Updated or Do Not Exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void GetOrderById() {
        System.out.printf("Enter Order ID: \n");
        int orderId = scanner.nextInt();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Order order = orderDAO.getOrderById(conn, orderId);
            System.out.println(order);
        } catch (Exception e) {
            System.out.println("This ID does not exist");
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void GetAll() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            List<Order> list = orderDAO.getAll(conn);
            list.forEach(System.out::println);
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

}
