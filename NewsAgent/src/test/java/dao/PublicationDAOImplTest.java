
package dao;

import controller.DaoExceptionHandler;
import junit.framework.TestCase;
import model.Order;
import model.Publication;
import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class PublicationDAOImplTest extends TestCase {

    PublicationDAO publicationDAO = new PublicationDAOImpl();

    //Test #: 1
    //Test Objective: To insert a Publication
    public void testPublicationDAO001() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Publication publication001 = new Publication("newspaper", 150,1000);
            boolean insert = publicationDAO.insert(coon, publication001);
            assertEquals(true, insert);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 2
    //Test Objective: To delete a Publication by id
    public void testPublicationDAO002() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Publication publication002 = new Publication("newspaper", 150,1000);
            boolean delete = publicationDAO.deleteById(coon, publication002.getPid());
            assertEquals(true, delete);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 3
    //Test Objective: To update a Publication by id
    public void testPublicationDAO003() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Publication publication003 = new Publication("newspaper", 100,1000);
            boolean update = publicationDAO.update(coon, publication003);
            assertEquals(true, update);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 4
    //Test Objective: To get a Publication by id
    public void testPublicationDAO004() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Publication publication004 = new Publication("newspaper", 100,1000);
            publicationDAO.insert(coon, publication004);
            List<Publication> all = publicationDAO.getAll(coon);
            Publication publication = publicationDAO.getPublicationById(coon, all.get(all.size() - 1).getPid());
            assertTrue(publication != null);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 3
    //Test Objective: To get Publications
    public void testPublicationDAO005() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            List<Publication> all = publicationDAO.getAll(coon);
            assertTrue(all != null);
        } catch (SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

}
