package dao;

import model.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
/**
 * @ClassName EmployeeDAO
 * @Description Override EmployeeDAO method
 * @Author Minjun Dai @Email A00279566@student.ait.ie
 * @Date 2021/2/14 02:06
 * @Version 1.0
 */

public interface EmployeeDAO {


    boolean insert(Connection conn, Employee cust);


    boolean deleteById(Connection conn, int id);


    boolean update(Connection conn, Employee cust);


    Employee getEmployeeById(Connection conn, int id);


    List<Employee> getAll(Connection conn);

}

