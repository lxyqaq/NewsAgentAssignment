package controller;

import dao.BillDAO;
import dao.BillDAOImpl;
import model.Bill;
import utils.JDBCUtils;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName BillController
 * @Description BillController database CRUD method
 * @Author Minjun Dai @Email A00279566@student.ait.ie
 * @Date 2021/2/9 18:18
 * @Version 1.0
 */
public class BillController {

    private Scanner scanner = new Scanner(System.in);
    private BillDAO billDAO = new BillDAOImpl();

    // BillDAO Method:
    public void Insert() {
        System.out.printf("Enter customerName: \n");
        String customerName = scanner.next();
        System.out.printf("Enter customerAddress: \n");
        String customerAddress = scanner.next();
        System.out.printf("Enter fee: \n");
        Double fee = scanner.nextDouble();
        System.out.printf("Enter date: \n");
        String date = scanner.next();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Bill bill = new Bill(customerName, customerAddress, fee, date);
            boolean insert = billDAO.insert(conn, bill);
            if (insert == true) {
                System.out.println("Bill Details Saved");
            } else {
                System.out.println("ERROR: Bill Details NOT Saved");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void DeleteById() {
        System.out.printf("Enter Bill ID: \n");
        int billId = scanner.nextInt();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            boolean delete = billDAO.deleteById(conn, billId);
            if (delete == true) {
                System.out.println("Bill Deleted");
            } else {
                System.out.println("ERROR: Bill Details NOT Deleted or Do Not Exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void Update() {
        System.out.printf("Enter Bill ID: \n");
        int billId = scanner.nextInt();
        System.out.printf("Enter customerName: \n");
        String customerName = scanner.next();
        System.out.printf("Enter customerAddress: \n");
        String customerAddress = scanner.next();
        System.out.printf("Enter fee: \n");
        double fee = scanner.nextDouble();
        System.out.printf("Enter date: \n");
        String date = scanner.next();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Bill bilt = new Bill(billId, customerName, customerAddress, fee, date);
            boolean update = billDAO.update(conn, bilt);
            if (update == true) {
                System.out.println("Bill Updated");
            } else {
                System.out.println("ERROR: Bill Details NOT Updated or Do Not Exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void GetBillById() {
        System.out.printf("Enter Bill ID: \n");
        int billId = scanner.nextInt();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Bill bilt = billDAO.getBillById(conn, billId);
            System.out.println(bilt);
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
            List<Bill> list = billDAO.getAll(conn);
            list.forEach(System.out::println);
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

}

