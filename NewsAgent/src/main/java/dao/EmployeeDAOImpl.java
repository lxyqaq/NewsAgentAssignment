package dao;

import model.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;


public class EmployeeDAOImpl extends BaseDAO<Employee> implements EmployeeDAO {

    @Override
    public void insert(Connection conn, Employee cust) {
        String sql = "insert into employee(name,email,address,phoneNumber)values(?,?,?,?)";
        update(conn, sql, cust.getName(), cust.getEmail(), cust.getAddress(), cust.getPhoneNumber());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from employee where id = ?";
        update(conn, sql, id);
    }

    @Override
    public void update(Connection conn, Employee cust) {
        String sql = "update employee set name = ?,email = ?,address = ?,phoneNumber = ? where id = ?";
        update(conn, sql, cust.getName(), cust.getEmail(), cust.getAddress(),cust.getPhoneNumber(), cust.getId());
    }

    @Override
    public Employee getEmployeeById(Connection conn, int id) {
        String sql = "select id,name,email,address,phoneNumber from employee where id = ?";
        Employee employee = getInstance(conn, sql, id);
        return employee;
    }

    @Override
    public List<Employee> getAll(Connection conn) {
        String sql = "select * from employee";
        List<Employee> list = getForList(conn, sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from employee";
        return getValue(conn, sql);
    }

}

