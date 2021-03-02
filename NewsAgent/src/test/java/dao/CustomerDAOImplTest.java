package dao;

import controller.DaoExceptionHandler;
import junit.framework.TestCase;
import model.Customer;
import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerDAOImplTest extends TestCase {

    CustomerDAO customerDAO = new CustomerDAOImpl();

    //Test #: 1
    //Test Objective: To insert a Customer Account
    //Inputs: CustomerName = "Jack", CustomerEmail = "jack@gmail.com", CustomerAddress = Athlone,
    //CustomerPhoneNumber = 0830120548
    //Expected Output: Customer Object created with id = 0, "Jack", CustomerEmail = "jack@gmail.com",
    //CustomerAddress = Athlone, CustomerPhoneNumber = 0830120548
    public void testCustomerDAO001() {

        try {
            Connection coon = JDBCUtils.getConnection();
            Customer customer001 = new Customer("Jack", "jack@gmail.com", "Athlone", "0830120548");
            customerDAO.insert(coon, customer001);
            List<Customer> customerList = customerDAO.getAll(coon);
            assertEquals(customer001.getName(), customerList.get(customerList.size() - 1).getName());
            assertEquals(customer001.getEmail(), customerList.get(customerList.size() - 1).getEmail());
            assertEquals(customer001.getAddress(), customerList.get(customerList.size() - 1).getAddress());
            assertEquals(customer001.getPhoneNumber(), customerList.get(customerList.size() - 1).getPhoneNumber());
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        }

    }

    public void testCustomerDAO002() {

        try {
            Connection coon = JDBCUtils.getConnection();
            Customer customer002 = new Customer("J", "jack@gmail.com", "Athlone", "0830120548");
            customerDAO.insert(coon, customer002);
        } catch (DaoExceptionHandler | SQLException e) {
            assertEquals("Customer Name does not meet minimum length requirements", e.getMessage());
        }

    }

}