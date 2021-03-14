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
    //Inputs: BillName = "Jack", BillEmail = "jack@gmail.com", BillAddress = Athlone,
    //BillPhoneNumber = 0830120548
    //Expected Output: Bill Object created with id = 0, "Jack", BillEmail = "jack@gmail.com",
    //BillAddress = Athlone, BillPhoneNumber = 0830120548
    public void testBillDAO001() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Bill bill001 = new Bill("Jack", "jack@gmail.com", "Athlone", "0830120548");
            boolean insert = billDAO.insert(coon, bill001);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon,null);
        }

    }

    //Test #: 2
    //Test Objective: To delete a Bill Account by id
    //Inputs: BillName = "Jack", BillEmail = "jack@gmail.com", BillAddress = Athlone,
    //BillPhoneNumber = 0830120548
    //Expected Output: Bill Object created with id = 0, "Jack", BillEmail = "jack@gmail.com",
    //BillAddress = Athlone, BillPhoneNumber = 0830120548
    public void testBillDAO002() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            coon.setAutoCommit(false);
            Bill bill002 = new Bill("Jack", "jack@gmail.com", "Athlone", "0830120548");
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
    public void testCustometDAO003() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            coon.setAutoCommit(false);
            Bill bill003 = new Bill("Jack", "jack@gmail.com", "Athlone", "0830120548");
            billDAO.insert(coon, bill003);
            Bill billUpdate003 = new Bill("Nathan", "nathan@gmail.com", "Dublin", "0830110548");
            billDAO.update(coon, billUpdate003);
            List<Bill> billList = billDAO.getAll(coon);
            assertEquals(bill003.getName(), billList.get(billList.size() - 1).getName());
            assertEquals(bill003.getEmail(), billList.get(billList.size() - 1).getEmail());
            assertEquals(bill003.getAddress(), billList.get(billList.size() - 1).getAddress());
            assertEquals(bill003.getPhoneNumber(), billList.get(billList.size() - 1).getPhoneNumber());
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
            Bill bill004 = new Bill("Jack", "jack@gmail.com", "Athlone", "0830120548");
            billDAO.insert(coon, bill004);
            List<Bill> billList = billDAO.getAll(coon);
            Bill bill = billDAO.getBillById(coon, billList.get(billList.size() - 1).getId());
            assertEquals(bill004.getName(), bill.getName());
            assertEquals(bill004.getEmail(), bill.getEmail());
            assertEquals(bill004.getAddress(), bill.getAddress());
            assertEquals(bill004.getPhoneNumber(), bill.getPhoneNumber());
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

