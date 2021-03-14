package controller;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;
import utils.JDBCUtils;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName EmployeeController
 * @Description Override EmployeeDAO method
 * @Author Minjun Dai @Email A00279566@student.ait.ie
 * @Date 2021/2/14 02:06
 * @Version 1.0
 */
public class EmployeeController {

    private Scanner scanner = new Scanner(System.in);
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    // EmployeeDAO Method:
    public void Insert() {
        System.out.printf("Enter Employee Name: \n");
        String employeeName = scanner.next();
        System.out.printf("Enter Employee Emali: \n");
        String employeeEmail = scanner.next();
        System.out.printf("Enter Employee Address: \n");
        String employeeAddress = scanner.next();
        System.out.printf("Enter Employee PhoneNumber: \n");
        String employeePhoneNumber = scanner.next();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Employee cust = new Employee(employeeName, employeeEmail, employeeAddress, employeePhoneNumber);
            boolean insert = employeeDAO.insert(conn, cust);
            if (insert == true) {
                System.out.println("Employee Details Saved");
            } else {
                System.out.println("ERROR: Employee Details NOT Saved");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void DeleteById() {
        System.out.printf("Enter Employee ID: \n");
        int employeeId = scanner.nextInt();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            boolean delete = employeeDAO.deleteById(conn, employeeId);
            if (delete == true) {
                System.out.println("Employee Deleted");
            } else {
                System.out.println("ERROR: Employee Details NOT Deleted or Do Not Exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void Update() {
        System.out.printf("Enter Employee ID: \n");
        int employeeId = scanner.nextInt();
        System.out.printf("Enter Employee Name: \n");
        String employeeName = scanner.next();
        System.out.printf("Enter Employee Emali: \n");
        String employeeEmail = scanner.next();
        System.out.printf("Enter Employee Address: \n");
        String employeeAddress = scanner.next();
        System.out.printf("Enter Employee PhoneNumber: \n");
        String employeePhoneNumber = scanner.next();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Employee cust = new Employee(employeeId, employeeName, employeeEmail, employeeAddress, employeePhoneNumber);
            boolean update = employeeDAO.update(conn, cust);
            if (update == true) {
                System.out.println("Employee Updated");
            } else {
                System.out.println("ERROR: Employee Details NOT Updated or Do Not Exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void GetEmployeeById() {
        System.out.printf("Enter Employee ID: \n");
        int employeeId = scanner.nextInt();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Employee cust = employeeDAO.getEmployeeById(conn, employeeId);
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
            List<Employee> list = employeeDAO.getAll(conn);
            list.forEach(System.out::println);
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

}

