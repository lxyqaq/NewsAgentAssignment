package controller;

import dao.InvoiceDAO;
import dao.InvoiceDAOImpl;
import model.Bill;
import model.Invoice;
import utils.JDBCUtils;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName InvoiceController
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/4/5 17:30
 * @Version 1.0
 */
public class InvoiceController {

    private Scanner scanner = new Scanner(System.in);
    private InvoiceDAO invoiceDAO = new InvoiceDAOImpl();

    public void DeleteById() {
        System.out.printf("Enter Invoice ID: \n");
        int invoiceId = scanner.nextInt();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            boolean delete = invoiceDAO.deleteById(conn, invoiceId);
            if (delete == true) {
                System.out.println("Invoice Deleted");
            } else {
                System.out.println("ERROR: Invoice Details NOT Deleted or Do Not Exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void Update() {
        System.out.printf("Enter Invoice ID: \n");
        int invoiceId = scanner.nextInt();
        System.out.printf("Enter Customer Name: \n");
        String cName = scanner.next();
        System.out.printf("Enter Publication Name: \n");
        String pName = scanner.next();
        System.out.printf("Enter Quantity: \n");
        int quantity = scanner.nextInt();
        System.out.printf("Enter Customer Address: \n");
        String cAddress = scanner.next();
        System.out.printf("Enter Date: \n");
        String date = scanner.next();
        System.out.printf("Enter Total: \n");
        double total = scanner.nextDouble();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Invoice invoice = new Invoice(invoiceId, cName, pName, quantity, cAddress, date, total);
            boolean update = invoiceDAO.update(conn, invoice);
            if (update == true) {
                System.out.println("Invoice Updated");
            } else {
                System.out.println("ERROR: Invoice Details NOT Updated or Do Not Exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void GetInvoiceById() {
        System.out.printf("Enter Invoice ID: \n");
        int invoiceId = scanner.nextInt();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Invoice invoice = invoiceDAO.getInvoiceById(conn, invoiceId);
            System.out.println(invoice);
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
            List<Invoice> list = invoiceDAO.getAll(conn);
            list.forEach(System.out::println);
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

}
