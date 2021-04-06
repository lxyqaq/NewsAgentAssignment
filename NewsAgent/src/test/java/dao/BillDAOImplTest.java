
package dao;

import controller.DaoExceptionHandler;
import junit.framework.TestCase;
import model.Customer;
import model.Bill;
import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * @ClassName BillDAOImplTest
 * @Description TODO
 * @Author Minjun Dai @Email A00279566@student.ait.ie
 * @Date 2021/3/14 20:50
 * @Version 1.0
 */

public class BillDAOImplTest extends TestCase {

    BillDAO billDAO = new BillDAOImpl();

    //Test #: 1
    //Test Objective: To insert a Bill
    public void testBillDAO001() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Bill bill001 = new Bill(1,"Jack", "No.8 willow park", "830431515",100, "11/11/2021");
            boolean insert = billDAO.insert(coon, bill001);
            assertEquals(true, insert);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 2
    //Test Objective: To delete a Bill by id
    public void testBillDAO002() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Bill bill002 = new Bill(1,"Jack", "No.8 willow park", "830431515",100, "11/11/2021");
            boolean delete = billDAO.deleteById(coon, bill002.getBid());
            assertEquals(true, delete);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 3
    //Test Objective: To update a Customer Account Bill by id
    public void testBillDAO003() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Bill bill003 = new Bill(1,"Jack", "No.8 willow park", "830431515",100, "11/11/2021");
            boolean update = billDAO.update(coon, bill003);
            assertEquals(true, update);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 4
    //Test Objective: To get a Bill by id
    public void testBillDAO004() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Bill bill004 = new Bill(1,"Jack", "No.8 willow park", "830431515",100, "11/11/2021");
            billDAO.insert(coon, bill004);
            List<Bill> all = billDAO.getAll(coon);
            Bill bill = billDAO.getBillById(coon, all.get(all.size() - 1).getBid());
            assertTrue(bill != null);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 3
    //Test Objective: To get Bills
    public void testBillDAO005() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            List<Bill> all = billDAO.getAll(coon);
            assertTrue(all != null);
        } catch (SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

}