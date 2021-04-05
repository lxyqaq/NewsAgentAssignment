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
        String sql = "insert into `order`(cname,cemail,caddress,cphone,pname,price,quantity,odate)values(?,?,?,?,?,?,?,?)";
        boolean insert = update(conn, sql, order.getCname(), order.getCemail(), order.getCaddress(), order.getCphone(), order.getPname(), order.getPrice(), order.getQuantity(), order.getOdate());
        return insert;
    }

    @Override
    public boolean deleteById(Connection conn, int id) {
        String sql = "delete from `order` where oid = ?";
        boolean delete = update(conn, sql, id);
        return delete;
    }

    @Override
    public boolean update(Connection conn, Order order) {
        String sql = "update `order` set cname = ?,cemail = ?,caddress = ?,cphone = ?,pname = ?,price = ?,quantity = ?,odate = ? where oid = ?";
        boolean update = update(conn, sql, order.getCname(), order.getCemail(), order.getCaddress(), order.getCphone(), order.getPname(), order.getPrice(), order.getQuantity(), order.getOdate(), order.getOid());
        return update;
    }

    @Override
    public Order getOrderById(Connection conn, int id) {
        String sql = "select * from `order` where oid = ?";
        Order order = getInstance(conn, sql, id);
        return order;
    }

    @Override
    public List<Order> getAll(Connection conn) {
        String sql = "select * from `order`";
        List<Order> list = getForList(conn, sql);
        return list;
    }

}
