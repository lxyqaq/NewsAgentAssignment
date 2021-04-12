package dao;

import controller.DaoExceptionHandler;
import junit.framework.TestCase;
import model.Invoice;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName InvoiceDAOImplTest
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/4/12 12:52
 * @Version 1.0
 */
public class InvoiceDAOImplTest extends TestCase {

    InvoiceDAO invoiceDAO = new InvoiceDAOImpl();

    //Test #: 1
    //Test Objective: To insert a Invoice
    public void testInvoicaDAO001() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Invoice invoice001 = new Invoice("Jack", "Newspaper", 30, "Athlone", "11/11/1111", 120);
            boolean insert = invoiceDAO.insert(coon, invoice001);
            assertEquals(true, insert);
        } catch (SQLException | DaoExceptionHandler e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 2
    //Test Objective: To delete a Invoice by id
    public void testInvoiceDAO002() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Invoice invoice002 = new Invoice("Jack", "Newspaper", 30, "Athlone", "11/11/1111", 120);
            boolean delete = invoiceDAO.deleteById(coon, invoice002.getIid());
            assertEquals(true, delete);
        } catch (SQLException | DaoExceptionHandler e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 3
    //Test Objective: To update a Customer Account Bill by id
    public void testInvoiceDAO003() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Invoice invoice003 = new Invoice("Jack", "Newspaper", 30, "Athlone", "11/11/1111", 120);
            boolean update = invoiceDAO.update(coon, invoice003);
            assertEquals(true, update);
        } catch (SQLException | DaoExceptionHandler e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 4
    //Test Objective: To get a Invoice by id
    public void testInvoiceDAO004() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Invoice invoice004 = new Invoice("Jack", "Newspaper", 30, "Athlone", "11/11/1111", 120);
            invoiceDAO.insert(coon, invoice004);
            List<Invoice> all = invoiceDAO.getAll(coon);
            Invoice invoice = invoiceDAO.getInvoiceById(coon, all.get(all.size() - 1).getIid());
            assertTrue(invoice != null);
        } catch (SQLException | DaoExceptionHandler e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 5
    //Test Objective: To get Invoices
    public void testInvoiceDAO005() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            List<Invoice> all = invoiceDAO.getAll(coon);
            assertTrue(all != null);
        } catch (SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

}
