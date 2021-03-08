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
    //Inputs: CustomerName = "Jack", CustomerEmail = "jack@gmail.com", CustomerAddress = Athlone,
    //CustomerPhoneNumber = 0830120548
    //Expected Output: Customer Object created with id = 0, "Jack", CustomerEmail = "jack@gmail.com",
    //CustomerAddress = Athlone, CustomerPhoneNumber = 0830120548
    public void testCustomerDAO001() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            coon.setAutoCommit(false);
            Customer customer001 = new Customer("Jack", "jack@gmail.com", "Athlone", "0830120548");
            customerDAO.insert(coon, customer001);
            List<Customer> customerList = customerDAO.getAll(coon);
            assertEquals(customer001.getName(), customerList.get(customerList.size() - 1).getName());
            assertEquals(customer001.getEmail(), customerList.get(customerList.size() - 1).getEmail());
            assertEquals(customer001.getAddress(), customerList.get(customerList.size() - 1).getAddress());
            assertEquals(customer001.getPhoneNumber(), customerList.get(customerList.size() - 1).getPhoneNumber());
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            try {
                coon.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                coon.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    //Test #: 2
    //Test Objective: To delete a Customer Account by id
    //Inputs: CustomerName = "Jack", CustomerEmail = "jack@gmail.com", CustomerAddress = Athlone,
    //CustomerPhoneNumber = 0830120548
    //Expected Output: Customer Object created with id = 0, "Jack", CustomerEmail = "jack@gmail.com",
    //CustomerAddress = Athlone, CustomerPhoneNumber = 0830120548
    public void testCustomerDAO002() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            coon.setAutoCommit(false);
            Customer customer002 = new Customer("Jack", "jack@gmail.com", "Athlone", "0830120548");
            customerDAO.insert(coon, customer002);
            List<Customer> customerList = customerDAO.getAll(coon);
            customerDAO.deleteById(coon, customerList.get(customerList.size() - 1).getId());
            assertNull(customerDAO.getCustomerById(coon, customerList.get(customerList.size() - 1).getId()));
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            try {
                coon.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                coon.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    //update
    public void testCustometDAO003() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            coon.setAutoCommit(false);
            Customer customer003 = new Customer("Jack", "jack@gmail.com", "Athlone", "0830120548");
            customerDAO.insert(coon, customer003);
            Customer customerUpdate003 = new Customer("Nathan", "nathan@gmail.com", "Dublin", "0830110548");
            customerDAO.update(coon, customerUpdate003);
            List<Customer> customerList = customerDAO.getAll(coon);
            assertEquals(customer003.getName(), customerList.get(customerList.size() - 1).getName());
            assertEquals(customer003.getEmail(), customerList.get(customerList.size() - 1).getEmail());
            assertEquals(customer003.getAddress(), customerList.get(customerList.size() - 1).getAddress());
            assertEquals(customer003.getPhoneNumber(), customerList.get(customerList.size() - 1).getPhoneNumber());
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            try {
                coon.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                coon.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    //getcustomerbyid
    public void testCustomerDAO004() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            coon.setAutoCommit(false);
            Customer customer004 = new Customer("Jack", "jack@gmail.com", "Athlone", "0830120548");
            customerDAO.insert(coon, customer004);
            List<Customer> customerList = customerDAO.getAll(coon);
            Customer customer = customerDAO.getCustomerById(coon, customerList.get(customerList.size() - 1).getId());
            assertEquals(customer004.getName(), customer.getName());
            assertEquals(customer004.getEmail(), customer.getEmail());
            assertEquals(customer004.getAddress(), customer.getAddress());
            assertEquals(customer004.getPhoneNumber(), customer.getPhoneNumber());
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            try {
                coon.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                coon.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

}