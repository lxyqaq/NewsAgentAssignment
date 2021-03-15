package model;

import controller.DaoExceptionHandler;
import junit.framework.TestCase;

/**
 * @ClassName BillTest
 * @Description Bill Test Coverage
 * @Author Minjun Dai @Email A00279566@student.ait.ie
 * @Date 2021/2/9 18:55
 * @Version 1.0
 */
public class BillTest extends TestCase {

    //Test #: 1
    //Test Objective: To create a Bill Account
    //Inputs: customerName = "Jack", customerAddress = "No.8 willow park", fee = 100,
    //date = "14/3/2021"
    //Expected Output: Bill Object created with id = 0, "Jack", customerAddress = "No.8 willow park", fee = 100,
    //date = "14/3/2021"
    public void testBill001() {

        try {
            Bill bill001 = new Bill("Jack", "No.8 willow park", 100, "");
            assertEquals(0, bill001.getId());
            assertEquals("Jack", bill001.getCustomerName());
            assertEquals("No.8 willow park", bill001.getCustomerAddress());
            assertEquals(100, bill001.getFee());
            assertEquals("14/3/2021", bill001.getDate());
        } catch (DaoExceptionHandler e) {
            fail("Exception not expected");
        }

    }

    //Test #: 2
    //Test Objective: To catch an incorrect lower boundary value customerName
    //Inputs: customerName = "J"
    //Expected Output: Exception Message: "Bill Name does not meet minimum length requirements"
    public void testBill002() {

        try {
            Bill.validateCustomerName("J");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Bill Name does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 3
    //Test Objective: To catch an incorrect Upper boundary value customerName
    //Inputs: customerName = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    //Expected Output: Exception Message: "customerName exceeds maximum length requirements"
    public void testBill003() {

        try {
            Bill.validateCustomerName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Bill Name exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 4
    //Test Objective: To catch an empty value customerName
    //Inputs: customerName = " "
    //Expected Output: Exception Message: "customerName NOT specified"
    public void testBill004() {

        try {
            Bill.validateCustomerName(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("customerName NOT specified", e.getMessage());
        }

    }

    //Test #: 5
    //Test Objective: To catch an empty value customerName
    //Inputs: customerName = ""
    //Expected Output: Exception Message: "customerName NOT specified"
    public void testBill005() {

        try {
            Bill.validateCustomerName("");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("customerName NOT specified", e.getMessage());
        }

    }

    //Test #: 6
    //Test Objective: To catch an incorrect lower boundary value customerAddress
    //Inputs: customerAddress = "At"
    //Expected Output: Exception Message: "customerAddress does not meet minimum length requirements"
    public void testBill006() {

        try {
            Bill.validateCustomerAddress("At");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("customerAddress does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 7
    //Test Objective: To catch an incorrect Upper boundary value customerAddress
    //Inputs: customerAddress = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    //Expected Output: Exception Message: "customerAddress exceeds maximum length requirements"
    public void testBill007() {

        try {
            Bill.validateCustomerAddress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("customerAddress exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 8
    //Test Objective: To catch an empty value customerAddress
    //Inputs: customerAddress = " "
    //Expected Output: Exception Message: "customerAddress NOT specified"
    public void testBill008() {

        try {
            Bill.validateCustomerAddress(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("customerAddress NOT specified", e.getMessage());
        }

    }

    //Test #: 9
    //Test Objective: To catch an empty value customerAddress
    //Inputs: customerAddress = ""
    //Expected Output: Exception Message: "customerAddress NOT specified"
    public void testBill009() {

        try {
            Bill.validateCustomerAddress("");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("customerAddress NOT specified", e.getMessage());
        }

    }

    //Test #: 10
    //Test Objective: To catch an incorrect lower boundary value Date
    //Inputs: Date = "15/3/2021"
    //Expected Output: Exception Message: "Date does not meet minimum length requirements"
    public void testBill010() {

        try {
            Bill.validateDate("15/3/201");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Date does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 11
    //Test Objective: To catch an incorrect Upper boundary value Date
    //Inputs: Date = "888888888888888888888888888888888888888"
    //Expected Output: Exception Message: "Date exceeds maximum length requirements"
    public void testBill011() {

        try {
            Bill.validateDate("15/3/20211111");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Date exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 12
    //Test Objective: To catch an empty value Date
    //Inputs: Date = " "
    //Expected Output: Exception Message: "Date NOT specified"
    public void testBill012() {

        try {
            Bill.validateDate(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Date NOT specified", e.getMessage());
        }

    }

    //Test #: 13
    //Test Objective: To catch an empty value Date
    //Inputs: Date = ""
    //Expected Output: Exception Message: "Date NOT specified"
    public void testBill014() {

        try {
            Bill.validateDate("");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Date NOT specified", e.getMessage());
        }

    }


    //Test #: 14
    //Test Objective: To test fee which is less than 0
    //Inputs: fee = -1
    //Expected Output: Exception Message: "Fee does not meet minimum length requirements"
    public void testBill015() {

        try {
            Bill.validateFee(-1);
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Fee does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 15
    //Test Objective: To test fee which is greater than 100000
    //Inputs: fee = 500000
    //Expected Output: Exception Message: "Fee does not meet maximum length requirements"
    public void testBill016() {

        try {
            Bill.validateFee(500000);
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Fee does not meet maximum length requirements", e.getMessage());
        }

    }

}

