package dao;

import model.Customer;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
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
    public boolean insert(Connection conn, Customer cust) {
        String sql = "insert into customer(cname,cemail,caddress,cphone)values(?,?,?,?)";
        boolean insert = update(conn, sql, cust.getName(), cust.getEmail(), cust.getAddress(), cust.getPhoneNumber());
        return insert;
    }

    @Override
    public boolean deleteById(Connection conn, int id) {
        String sql = "delete from customer where cid = ?";
        boolean delete = update(conn, sql, id);
        return delete;
    }

    @Override
    public boolean update(Connection conn, Customer cust) {
        String sql = "update customer set cname = ?,cemail = ?,caddress = ?,cphone = ? where cid = ?";
        boolean update = update(conn, sql, cust.getName(), cust.getEmail(), cust.getAddress(), cust.getPhoneNumber(), cust.getId());
        return update;
    }

    @Override
    public Customer getCustomerById(Connection conn, int id) {
        String sql = "select cid,cname,cemail,caddress,cphone from customer where cid = ?";
        Customer customer = getInstance(conn, sql, id);
        return customer;
    }

    @Override
    public List<Customer> getAll(Connection conn) {
        String sql = "select * from customer";
        List<Customer> list = getForList(conn, sql);
        return list;
    }

}