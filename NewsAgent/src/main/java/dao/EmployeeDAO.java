package dao;

import model.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;


public interface EmployeeDAO {


    void insert(Connection conn, Employee cust);


    void deleteById(Connection conn, int id);


    void update(Connection conn, Employee cust);


    Employee getEmployeeById(Connection conn, int id);


    List<Employee> getAll(Connection conn);


    Long getCount(Connection conn);

}

