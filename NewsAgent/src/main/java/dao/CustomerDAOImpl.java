package dao;

import model.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @ClassName CustomerDAOImpl
 * @Description Override CustomerDAO method
 * @Author Xiangyu Liu @Email A00279565@student.ait.ie
 * @Date 2021/2/8 02:06
 * @Version 1.0
 */
public class CustomerDAOImpl extends BaseDAO<Customer> implements CustomerDAO {

    @Override
    public void insert(Connection conn, Customer cust) {
        String sql = "insert into customer(name,email,address,phoneNumber)values(?,?,?,?)";
        update(conn, sql, cust.getName(), cust.getEmail(), cust.getAddress(), cust.getPhoneNumber());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from customer where id = ?";
        update(conn, sql, id);
    }

    @Override
    public void update(Connection conn, Customer cust) {
        String sql = "update customer set name = ?,email = ?,address = ?,phoneNumber = ? where id = ?";
        update(conn, sql, cust.getName(), cust.getEmail(), cust.getAddress(),cust.getPhoneNumber(), cust.getId());
    }

    @Override
    public Customer getCustomerById(Connection conn, int id) {
        String sql = "select id,name,email,address,phoneNumber from customer where id = ?";
        Customer customer = getInstance(conn, sql, id);
        return customer;
    }

    @Override
    public List<Customer> getAll(Connection conn) {
        String sql = "select id,name,email,address,phoneNumber from customer";
        List<Customer> list = getForList(conn, sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from customer";
        return getValue(conn, sql);
    }


}
