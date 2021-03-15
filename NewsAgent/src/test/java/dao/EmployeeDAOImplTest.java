package dao;

import controller.DaoExceptionHandler;
import junit.framework.TestCase;
import model.Employee;
import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAOImplTest extends TestCase {

    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    //Test #: 1
    //Test Objective: To insert a Employee Account
    public void testEmployeeDAO001() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Employee employee001 = new Employee("Jane", "jane@ait.ie", "Athlone", "0831515221");
            boolean insert = employeeDAO.insert(coon, employee001);
            assertEquals(true, insert);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 2
    //Test Objective: To delete a Employee Account by id
    public void testEmployeeDAO002() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            coon.setAutoCommit(false);
            Employee employee002 = new Employee("Jack", "jack@gmail.com", "Athlone", "0830120548");
            boolean delete = employeeDAO.deleteById(coon, employee002.getId());
            assertEquals(true, delete);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 3
    //Test Objective: To update a Employee Account by id
    public void testEmployeeDAO003() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Employee employee003 = new Employee("Jane", "jane@ait.ie", "Athlone", "0831515221");
            boolean update = employeeDAO.update(coon, employee003);
            assertEquals(true, update);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 4
    //Test Objective: To get a Employee Account by id
    public void testEmployeeDAO004() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            Employee employee004 = new Employee("Jane", "jane@ait.ie", "Athlone", "0831515221");
            employeeDAO.insert(coon, employee004);
            List<Employee> all = employeeDAO.getAll(coon);
            Employee employee = employeeDAO.getEmployeeById(coon, all.get(all.size() - 1).getId());
            assertTrue(employee != null);
        } catch (DaoExceptionHandler | SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

    //Test #: 5
    //Test Objective: To get Employee Accounts
    public void testEmployeeDAO005() {

        Connection coon = null;
        try {
            coon = JDBCUtils.getConnection();
            List<Employee> all = employeeDAO.getAll(coon);
            assertTrue(all != null);
        } catch (SQLException e) {
            fail("Exception not expected");
        } finally {
            JDBCUtils.closeResource(coon, null);
        }

    }

}

