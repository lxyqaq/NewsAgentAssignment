package dao;

import controller.DaoExceptionHandler;
import junit.framework.TestCase;
import model.Order;
import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * @ClassName OrderDAOImplTest
 * @Description OrderDAOImplTest class
 * @Author Xiangyu Liu @Email A00279565@student.ait.ie
 * @Date 2021/3/14 20:37
 * @Version 1.0
 */

public class OrderDAOImplTest extends TestCase {

    OrderDAO orderDAO = new OrderDAOImpl();

    //Test #: 1
    //Test Objective: To insert a Order
    public void testOrderDAO001() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Order order001 = new Order("Jack", "jack@gmail.com", "Athlone", "0830120845", "Newspaper", 4, 20, "11/11/2021");
            boolean insert = orderDAO.insert(coon, order001);
            assertEquals(true, insert);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 2
    //Test Objective: To delete a Order by id
    public void testOrderDAO002() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Order order002 = new Order("Jack", "jack@gmail.com", "Athlone", "0830120845", "Newspaper", 4, 20, "11/11/2021");
            boolean delete = orderDAO.deleteById(coon, order002.getOid());
            assertEquals(true, delete);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 3
    //Test Objective: To update a Customer Account by id
    public void testOrderDAO003() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Order order003 = new Order("Jack", "jack@gmail.com", "Athlone", "0830120845", "Newspaper", 4, 20, "11/11/2021");
            boolean update = orderDAO.update(coon, order003);
            assertEquals(true, update);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 4
    //Test Objective: To get a Order by id
    public void testOrderDAO004() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Order order004 = new Order("Jack", "jack@gmail.com", "Athlone", "0830120845", "Newspaper", 4, 20, "11/11/2021");
            orderDAO.insert(coon, order004);
            List<Order> all = orderDAO.getAll(coon);
            Order order = orderDAO.getOrderById(coon, all.get(all.size() - 1).getOid());
            assertTrue(order != null);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 3
    //Test Objective: To get Orders
    public void testOrderDAO005() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            List<Order> all = orderDAO.getAll(coon);
            assertTrue(all != null);
        } catch (SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

}

