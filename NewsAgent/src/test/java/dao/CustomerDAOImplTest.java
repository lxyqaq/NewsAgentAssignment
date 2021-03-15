package dao;

import controller.DaoExceptionHandler;
import junit.framework.TestCase;
import model.Customer;
import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImplTest extends TestCase {

    CustomerDAO customerDAO = new CustomerDAOImpl();

    //Test #: 1
    //Test Objective: To insert a Customer Account
    public void testCustomerDAO001() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Customer customer001 = new Customer("Jack", "jack@gmail.com", "Athlone", "0830120548");
            boolean insert = customerDAO.insert(coon, customer001);
            assertEquals(true, insert);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 2
    //Test Objective: To delete a Customer Account by id
    public void testCustomerDAO002() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            coon.setAutoCommit(false);
            Customer customer002 = new Customer("Jack", "jack@gmail.com", "Athlone", "0830120548");
            boolean delete = customerDAO.deleteById(coon, customer002.getId());
            assertEquals(true, delete);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 3
    //Test Objective: To update a Customer Account by id
    public void testCustomerDAO003() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Customer customer003 = new Customer("Jack", "jack@gmail.com", "Athlone", "0830120548");
            boolean update = customerDAO.update(coon, customer003);
            assertEquals(true, update);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 4
    //Test Objective: To get a Customer Account by id
    public void testCustomerDAO004() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Customer customer004 = new Customer("Jack", "jack@gmail.com", "Athlone", "0830120548");
            customerDAO.insert(coon, customer004);
            List<Customer> all = customerDAO.getAll(coon);
            Customer customer = customerDAO.getCustomerById(coon, all.get(all.size() - 1).getId());
            assertTrue(customer != null);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 5
    //Test Objective: To get Customer Accounts
    public void testCustomerDAO005() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            List<Customer> all = customerDAO.getAll(coon);
            assertTrue(all != null);
        } catch (SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

}