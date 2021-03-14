package dao;

import model.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @ClassName EmployeeDAOImpl
 * @Description Override EmployeeDAO method
 * @Author Minjun Dai @Email A00279566@student.ait.ie
 * @Date 2021/2/14 02:06
 * @Version 1.0
 */

public class EmployeeDAOImpl extends BaseDAO<Employee> implements EmployeeDAO {

    @Override
    public boolean insert(Connection conn, Employee cust) {
        String sql = "insert into employee(name,email,address,phoneNumber)values(?,?,?,?)";
        boolean insert = update(conn, sql, cust.getName(), cust.getEmail(), cust.getAddress(), cust.getPhoneNumber());
        return insert;
    }

    @Override
    public boolean deleteById(Connection conn, int id) {
        String sql = "delete from employee where id = ?";
        boolean delete = update(conn, sql, id);
        return delete;
    }

    @Override
    public boolean update(Connection conn, Employee cust) {
        String sql = "update employee set name = ?,email = ?,address = ?,phoneNumber = ? where id = ?";
        boolean update = update(conn, sql, cust.getName(), cust.getEmail(), cust.getAddress(), cust.getPhoneNumber(), cust.getId());
        return update;
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

