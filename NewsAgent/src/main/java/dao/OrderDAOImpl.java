package dao;

import model.Customer;
import model.Order;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName OrderDAOImpl
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/3/14 17:52
 * @Version 1.0
 */
public class OrderDAOImpl extends BaseDAO<Order> implements OrderDAO {

    @Override
    public boolean insert(Connection conn, Order order) {
        String sql = "insert into order(customerName,publicationName,date)values(?,?,?)";
        boolean insert = update(conn, sql, order.getCustomerName(), order.getPublicationName(), order.getDate());
        return insert;
    }

    @Override
    public boolean deleteById(Connection conn, int id) {
        String sql = "delete from order where id = ?";
        boolean delete = update(conn, sql, id);
        return delete;
    }

    @Override
    public boolean update(Connection conn, Order order) {
        String sql = "update order set customerName = ?,publicationName = ?,date = ? where id = ?";
        boolean update = update(conn, sql, order.getCustomerName(), order.getPublicationName(), order.getDate(), order.getId());
        return update;
    }

    @Override
    public Order getCustomerById(Connection conn, int id) {
        String sql = "select id,customerName,publicationName,date from order where id = ?";
        Order order = getInstance(conn, sql, id);
        return order;
    }

    @Override
    public List<Order> getAll(Connection conn) {
        String sql = "select * from order";
        List<Order> list = getForList(conn, sql);
        return list;
    }

}
