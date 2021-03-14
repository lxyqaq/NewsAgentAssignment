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
    //Inputs: BillName = "Jack", BillEmail = "jack@gmail.com", BillAddress = Athlone,
    //BillPhoneNumber = 0830120548
    //Expected Output: Bill Object created with id = 0, "Jack", BillEmail = "jack@gmail.com",
    //BillAddress = Athlone, BillPhoneNumber = 0830120548
    public void testBill001() {

        try {
            Bill bill001 = new Bill("Jack", "jack@gmail.com", "Athlone", "0830120548");
            assertEquals(0, bill001.getId());
            assertEquals("Jack", bill001.getName());
            assertEquals("jack@gmail.com", bill001.getEmail());
            assertEquals("Athlone", bill001.getAddress());
            assertEquals("0830120548", bill001.getPhoneNumber());
        } catch (DaoExceptionHandler e) {
            fail("Exception not expected");
        }

    }

    //Test #: 2
    //Test Objective: To catch an incorrect lower boundary value Bill name
    //Inputs: BillName = "J"
    //Expected Output: Exception Message: "Bill Name does not meet minimum length requirements"
    public void testBill002() {

        try {
            Bill.validateName("J");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Bill Name does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 3
    //Test Objective: To catch an incorrect Upper boundary value Bill name
    //Inputs: BillName = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    //Expected Output: Exception Message: "Bill Name exceeds maximum length requirements"
    public void testBill003() {

        try {
            Bill.validateName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Bill Name exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 4
    //Test Objective: To catch an empty value Bill Name
    //Inputs: BillName = " "
    //Expected Output: Exception Message: "Bill Name NOT specified"
    public void testBill004() {

        try {
            Bill.validateName(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Bill Name NOT specified", e.getMessage());
        }

    }

    //Test #: 5
    //Test Objective: To catch an empty value Bill Name
    //Inputs: BillName = ""
    //Expected Output: Exception Message: "Bill Name NOT specified"
    public void testBill005() {

        try {
            Bill.validateName("");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Bill Name NOT specified", e.getMessage());
        }

    }

    //Test #: 6
    //Test Objective: To catch an incorrect lower boundary value Bill Address
    //Inputs: BillAddress = "At"
    //Expected Output: Exception Message: "Bill Address does not meet minimum length requirements"
    public void testBill006() {

        try {
            Bill.validateAddress("At");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Bill Address does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 7
    //Test Objective: To catch an incorrect Upper boundary value Bill Address
    //Inputs: BillAddress = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    //Expected Output: Exception Message: "Bill Address exceeds maximum length requirements"
    public void testBill007() {

        try {
            Bill.validateAddress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Bill Address exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 8
    //Test Objective: To catch an empty value Bill Address
    //Inputs: BillAddress = " "
    //Expected Output: Exception Message: "Bill Address NOT specified"
    public void testBill008() {

        try {
            Bill.validateAddress(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Bill Address NOT specified", e.getMessage());
        }

    }

    //Test #: 9
    //Test Objective: To catch an empty value Bill Address
    //Inputs: BillAddress = ""
    //Expected Output: Exception Message: "Bill Address NOT specified"
    public void testBill009() {

        try {
            Bill.validateAddress("");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Bill Address NOT specified", e.getMessage());
        }

    }

    //Test #: 10
    //Test Objective: To catch an incorrect lower boundary value Bill PhoneNumber
    //Inputs: BillPhone = "083"
    //Expected Output: Exception Message: "Bill PhoneNumber does not meet minimum length requirements"
    public void testBill010() {

        try {
            Bill.validatePhoneNumber("083");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Bill PhoneNumber does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 11
    //Test Objective: To catch an incorrect Upper boundary value Bill PhoneNumber
    //Inputs: BillPhone = "888888888888888888888888888888888888888"
    //Expected Output: Exception Message: "Bill PhoneNumber exceeds maximum length requirements"
    public void testBill011() {

        try {
            Bill.validatePhoneNumber("888888888888888888888888888888888888888");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Bill PhoneNumber exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 12
    //Test Objective: To catch an empty value Bill PhoneNumber
    //Inputs: BillPhone = " "
    //Expected Output: Exception Message: "Bill PhoneNumber NOT specified"
    public void testBill012() {

        try {
            Bill.validatePhoneNumber(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Bill PhoneNumber NOT specified", e.getMessage());
        }

    }

    //Test #: 13
    //Test Objective: To catch an empty value Bill PhoneNumber
    //Inputs: BillPhone = ""
    //Expected Output: Exception Message: "Bill PhoneNumber NOT specified"
    public void testBill013() {

        try {
            Bill.validatePhoneNumber("");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Bill PhoneNumber NOT specified", e.getMessage());
        }

    }

}

