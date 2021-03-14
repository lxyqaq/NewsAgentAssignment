package dao;

import model.Order;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName OrderDAO
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/3/14 17:49
 * @Version 1.0
 */
public interface OrderDAO {

    boolean insert(Connection conn, Order order);

    boolean deleteById(Connection conn, int id);

    boolean update(Connection conn, Order order);

    Order getCustomerById(Connection conn, int id);

    List<Order> getAll(Connection conn);

}
