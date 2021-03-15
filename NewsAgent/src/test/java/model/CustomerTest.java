package model;

import controller.DaoExceptionHandler;
import junit.framework.TestCase;

/**
 * @ClassName CustomerTest
 * @Description Customer Test Coverage
 * @Author Xiangyu Liu @Email A00279565@student.ait.ie
 * @Date 2021/2/9 18:55
 * @Version 1.0
 */
public class CustomerTest extends TestCase {

    //Test #: 1
    //Test Objective: To create a Customer Account
    //Inputs: CustomerName = "Jack", CustomerEmail = "jack@gmail.com", CustomerAddress = Athlone,
    //CustomerPhoneNumber = 0830120548
    //Expected Output: Customer Object created with id = 0, "Jack", CustomerEmail = "jack@gmail.com",
    //CustomerAddress = Athlone, CustomerPhoneNumber = 0830120548
    public void testCustomer001() {

        try {
            Customer customer001 = new Customer("Jack", "jack@gmail.com", "Athlone", "0830120548");
            assertEquals("Jack", customer001.getName());
            assertEquals("jack@gmail.com", customer001.getEmail());
            assertEquals("Athlone", customer001.getAddress());
            assertEquals("0830120548", customer001.getPhoneNumber());
        } catch (DaoExceptionHandler e) {
            fail("Exception not expected");
        }

    }

    //Test #: 2
    //Test Objective: To catch an incorrect lower boundary value Customer name
    //Inputs: CustomerName = "J"
    //Expected Output: Exception Message: "Customer Name does not meet minimum length requirements"
    public void testCustomer002() {

        try {
            Customer.validateName("J");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer Name does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 3
    //Test Objective: To catch an incorrect Upper boundary value Customer name
    //Inputs: CustomerName = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    //Expected Output: Exception Message: "Customer Name exceeds maximum length requirements"
    public void testCustomer003() {

        try {
            Customer.validateName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer Name exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 4
    //Test Objective: To catch an empty value Customer Name
    //Inputs: CustomerName = " "
    //Expected Output: Exception Message: "Customer Name NOT specified"
    public void testCustomer004() {

        try {
            Customer.validateName(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer Name NOT specified", e.getMessage());
        }

    }

    //Test #: 5
    //Test Objective: To catch an empty value Customer Name
    //Inputs: CustomerName = ""
    //Expected Output: Exception Message: "Customer Name NOT specified"
    public void testCustomer005() {

        try {
            Customer.validateName("");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer Name NOT specified", e.getMessage());
        }

    }

    //Test #: 6
    //Test Objective: To catch an incorrect lower boundary value Customer Address
    //Inputs: CustomerAddress = "At"
    //Expected Output: Exception Message: "Customer Address does not meet minimum length requirements"
    public void testCustomer006() {

        try {
            Customer.validateAddress("At");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer Address does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 7
    //Test Objective: To catch an incorrect Upper boundary value Customer Address
    //Inputs: CustomerAddress = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    //Expected Output: Exception Message: "Customer Address exceeds maximum length requirements"
    public void testCustomer007() {

        try {
            Customer.validateAddress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer Address exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 8
    //Test Objective: To catch an empty value Customer Address
    //Inputs: CustomerAddress = " "
    //Expected Output: Exception Message: "Customer Address NOT specified"
    public void testCustomer008() {

        try {
            Customer.validateAddress(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer Address NOT specified", e.getMessage());
        }

    }

    //Test #: 9
    //Test Objective: To catch an empty value Customer Address
    //Inputs: CustomerAddress = ""
    //Expected Output: Exception Message: "Customer Address NOT specified"
    public void testCustomer009() {

        try {
            Customer.validateAddress("");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer Address NOT specified", e.getMessage());
        }

    }

    //Test #: 10
    //Test Objective: To catch an incorrect lower boundary value Customer PhoneNumber
    //Inputs: CustomerPhone = "083"
    //Expected Output: Exception Message: "Customer PhoneNumber does not meet minimum length requirements"
    public void testCustomer010() {

        try {
            Customer.validatePhoneNumber("083");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer PhoneNumber does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 11
    //Test Objective: To catch an incorrect Upper boundary value Customer PhoneNumber
    //Inputs: CustomerPhone = "888888888888888888888888888888888888888"
    //Expected Output: Exception Message: "Customer PhoneNumber exceeds maximum length requirements"
    public void testCustomer011() {

        try {
            Customer.validatePhoneNumber("888888888888888888888888888888888888888");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer PhoneNumber exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 12
    //Test Objective: To catch an empty value Customer PhoneNumber
    //Inputs: CustomerPhone = " "
    //Expected Output: Exception Message: "Customer PhoneNumber NOT specified"
    public void testCustomer012() {

        try {
            Customer.validatePhoneNumber(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer PhoneNumber NOT specified", e.getMessage());
        }

    }

    //Test #: 13
    //Test Objective: To catch an empty value Customer PhoneNumber
    //Inputs: CustomerPhone = ""
    //Expected Output: Exception Message: "Customer PhoneNumber NOT specified"
    public void testCustomer013() {

        try {
            Customer.validatePhoneNumber("");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer PhoneNumber NOT specified", e.getMessage());
        }

    }

    //Test #: 14
    //Test Objective: To catch an incorrect lower boundary value Customer Email
    //Inputs: Email = "aa"
    //Expected Output: Exception Message: "Customer Email does not meet minimum length requirements"
    public void testCustomer014() {

        try {
            Customer.validateEmail("a");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer Email does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 11
    //Test Objective: To catch an incorrect Upper boundary value Customer Email
    //Inputs: Email = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    //Expected Output: Exception Message: "Customer Email exceeds maximum length requirements"
    public void testCustomer015() {

        try {
            Customer.validateEmail("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer Email exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 12
    //Test Objective: To catch an empty value Customer Email
    //Inputs: Email = " "
    //Expected Output: Exception Message: "Customer Email NOT specified"
    public void testCustomer016() {

        try {
            Customer.validateEmail(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer Email NOT specified", e.getMessage());
        }

    }

    //Test #: 13
    //Test Objective: To catch an empty value Customer Email
    //Inputs: Email = ""
    //Expected Output: Exception Message: "Customer Email NOT specified"
    public void testCustomer017() {

        try {
            Customer.validateEmail("");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Customer Email NOT specified", e.getMessage());
        }

    }

}