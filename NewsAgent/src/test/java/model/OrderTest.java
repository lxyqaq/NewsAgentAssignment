package model;

import controller.DaoExceptionHandler;
import junit.framework.TestCase;

/**
 * @ClassName OrderTest
 * @Description OrderTest
 * @Author Xiangyu Liu @Email A00279565@student.ait.ie
 * @Date 2021/3/15 13:12
 * @Version 1.0
 */

public class OrderTest extends TestCase {

    //Test #: 1
    //Test Objective: To create a Order
    //Inputs: CustomerName = "Jack", publicationName = "newspaper", date = "12/1/2020",
    //Expected Output: Order Object created with id = 0, "Jack", publicationName = "newspaper",
    //date = 12/1/2020
    public void testOrder001() {

        try {
            Order order001 = new Order("Jack", "jack@gmail.com", "Athlone", "0830120845", "Newspaper", 4, 20, "11/11/2021");
            assertEquals("Jack", order001.getCname());
            assertEquals("jack@gmail.com", order001.getCemail());
            assertEquals("Athlone", order001.getCaddress());
            assertEquals("0830120845", order001.getCphone());
            assertEquals("Newspaper", order001.getPname());
            assertEquals(4.0, order001.getPrice());
            assertEquals(20, order001.getQuantity());
            assertEquals("11/11/2021", order001.getOdate());
        } catch (DaoExceptionHandler e) {
            fail("Exception not expected");
        }

    }

    //Test #: 2
    //Test Objective: To catch an incorrect lower boundary value Customer name
    //Inputs: CustomerName = "J"
    //Expected Output: Exception Message: "Customer Name does not meet minimum length requirements"
    public void testOrder002() {

        try {
            Order.validateName("J");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer Name does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 3
    //Test Objective: To catch an incorrect Upper boundary value Customer name
    //Inputs: CustomerName = "JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ"
    //Expected Output: Exception Message: "Customer Name does not meet minimum length requirements"
    public void testOrder003() {

        try {
            Order.validateName("JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer Name exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 4
    //Test Objective: To catch an empty value Customer Name
    //Inputs: CustomerName = " "
    //Expected Output: Exception Message: "Customer Name NOT specified"
    public void testOrder004() {

        try {
            Order.validateName(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer Name NOT specified", e.getMessage());
        }

    }

    //Test #: 5
    //Test Objective: To catch an empty value Customer Name
    //Inputs: CustomerName = ""
    //Expected Output: Exception Message: "Customer Name NOT specified"
    public void testOrder005() {

        try {
            Order.validateName("");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer Name NOT specified", e.getMessage());
        }

    }

    //Test #: 6
    //Test Objective: To catch an incorrect lower boundary value Publication Name
    //Inputs: publicationName = "J"
    //Expected Output: Exception Message: "Publication Name does not meet minimum length requirements"
    public void testOrder006() {

        try {
            Order.validatePublication("J");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Publication Name does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 7
    //Test Objective: To catch an incorrect Upper boundary value Publication name
    //Inputs: publicationName = "JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ"
    //Expected Output: Exception Message: "Publication Name exceeds maximum length requirements"
    public void testOrder007() {

        try {
            Order.validatePublication("JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Publication Name exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 8
    //Test Objective: To catch an empty value Publication Name
    //Inputs: PublicationName = " "
    //Expected Output: Exception Message: "Publicaiton Name NOT specified"
    public void testOrder008() {

        try {
            Order.validatePublication(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Publication Name NOT specified", e.getMessage());
        }

    }

    //Test #: 9
    //Test Objective: To catch an empty value Publication Name
    //Inputs: PublicationName = ""
    //Expected Output: Exception Message: "Publicaiton Name NOT specified"
    public void testOrder009() {

        try {
            Order.validatePublication("");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Publication Name NOT specified", e.getMessage());
        }

    }

    //Test #: 10
    //Test Objective: To catch an incorrect lower boundary value Date
    //Inputs: Date = "11/"
    //Expected Output: Exception Message: "Deliver Date does not meet minimum length requirements"
    public void testOrder010() {

        try {
            Order.validateDate("11/");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Deliver Date does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 11
    //Test Objective: To catch an incorrect Upper boundary value Date
    //Inputs: Date = "11/11/11111"
    //Expected Output: Exception Message: "Publication Name exceeds maximum length requirements"
    public void testOrder011() {

        try {
            Order.validateDate("11/11/11111");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Deliver Date exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 12
    //Test Objective: To catch an empty value Date
    //Inputs: Date = " "
    //Expected Output: Exception Message: "Deliver Date NOT specified"
    public void testOrder012() {

        try {
            Order.validateDate(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Deliver Date NOT specified", e.getMessage());
        }

    }

    //Test #: 13
    //Test Objective: To catch an empty value Date
    //Inputs: Date = ""
    //Expected Output: Exception Message: "Deliver Date NOT specified"
    public void testOrder013() {

        try {
            Order.validateDate("");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Deliver Date NOT specified", e.getMessage());
        }

    }

}
