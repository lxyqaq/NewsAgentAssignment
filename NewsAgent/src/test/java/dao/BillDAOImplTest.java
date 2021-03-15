package dao;

import controller.DaoExceptionHandler;
import junit.framework.TestCase;
import model.Bill;
import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BillDAOImplTest extends TestCase {

    BillDAO billDAO = new BillDAOImpl();

    //Test #: 1
    //Test Objective: To insert a Bill Account
    //Inputs: customerName = "Jack", customerAddress = "No.8 willow park",  fee= 100,
    //date= 2021.3.14
    //Expected Output: Bill Object created with id = 0, "Jack", customerAddress = "green street",
    //fee= 100, date= 2021.3.14
    public void testBillDAO001() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Bill bill001 = new Bill("Jack", "No.8 willow park", "100", "2021.3.14");
            boolean insert = billDAO.insert(coon, bill001);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon,null);
        }

    }

    //Test #: 2
    //Test Objective: To delete a Bill Account by id
    //Inputs: customerName = "Jack", customerAddress = "No.8 willow park",  fee= 100,
    //date= 2021.3.14
    //Expected Output: Bill Object created with id = 0, "Jack", customerAddress = "green street",
    //fee= 100, date= 2021.3.14
    public void testBillDAO002() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            coon.setAutoCommit(false);
            Bill bill002 = new Bill("Jack", "No.8 willow park", "100", "2021.3.14");
            billDAO.insert(coon, bill002);
            List<Bill> billList = billDAO.getAll(coon);
            billDAO.deleteById(coon, billList.get(billList.size() - 1).getId());
            assertNull(billDAO.getBillById(coon, billList.get(billList.size() - 1).getId()));
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
    public void testBillDAO003() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            coon.setAutoCommit(false);
            Bill bill003 = new Bill("Jack", "No.8 willow park", 100, "2021.3.14");
            billDAO.insert(coon, bill003);
            Bill billUpdate003 = new Bill("Nathan", "No.8 willow park", 100, "2021.3.14");
            billDAO.update(coon, billUpdate003);
            List<Bill> billList = billDAO.getAll(coon);
            assertEquals(bill003.getCustomerName(), billList.get(billList.size() - 1).getCustomerName());
            assertEquals(bill003.getCustomerAddress(), billList.get(billList.size() - 1).getCustomerAddress());
            assertEquals(bill003.getFee(), billList.get(billList.size() - 1).getFee());
            assertEquals(bill003.getDate(), billList.get(billList.size() - 1).getDate());
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

    //getbillbyid
    public void testBillDAO004() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            coon.setAutoCommit(false);
            Bill bill004 = new Bill("Jack", "No.8 willow park", 100, "2021.3.14");
            billDAO.insert(coon, bill004);
            List<Bill> billList = billDAO.getAll(coon);
            Bill bill = billDAO.getBillById(coon, billList.get(billList.size() - 1).getId());
            assertEquals(bill004.getCustomerName(), bill.getCustomerName());
            assertEquals(bill004.getCustomerAddress(), bill.getCustomerAddress());
            assertEquals(bill004.getFee(), bill.getFee());
            assertEquals(bill004.getDate(), bill.getDate());
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

