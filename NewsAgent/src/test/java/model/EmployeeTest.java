package model;

import controller.DaoExceptionHandler;
import junit.framework.TestCase;


/**
 * @ClassName EmployeeTest
 * @Description Override EmployeeDAO method
 * @Author Minjun Dai @Email A00279566@student.ait.ie
 * @Date 2021/2/14 02:06
 * @Version 1.0
 */

public class EmployeeTest extends TestCase {

    //Test #: 1
    //Test Objective: To create a Employee Account
    //Inputs: EmployeeName = "Jack", EmployeeEmail = "jack@gmail.com", EmployeeAddress = Athlone,
    //EmployeePhoneNumber = 0830120548
    //Expected Output: Employee Object created with id = 0, "Jack", EmployeeEmail = "jack@gmail.com",
    //EmployeeAddress = Athlone, EmployeePhoneNumber = 0830120548
    public void testEmployee001() {

        try {
            Employee employee001 = new Employee("Jack", "jack@gmail.com", "Athlone", "0830120548");
            assertEquals(0, employee001.getId());
            assertEquals("Jack", employee001.getName());
            assertEquals("jack@gmail.com", employee001.getEmail());
            assertEquals("Athlone", employee001.getAddress());
            assertEquals("0830120548", employee001.getPhoneNumber());
        } catch (DaoExceptionHandler e) {
            fail("Exception not expected");
        }

    }

    //Test #: 2
    //Test Objective: To catch an incorrect lower boundary value Employee name
    //Inputs: EmployeeName = "J"
    //Expected Output: Exception Message: "Employee Name does not meet minimum length requirements"
    public void testEmployee002() {

        try {
            Employee.validateName("J");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Employee Name does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 3
    //Test Objective: To catch an incorrect Upper boundary value Employee name
    //Inputs: EmployeeName = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    //Expected Output: Exception Message: "Employee Name exceeds maximum length requirements"
    public void testEmployee003() {

        try {
            Employee.validateName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Employee Name exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 4
    //Test Objective: To catch an empty value Employee Name
    //Inputs: EmployeeName = " "
    //Expected Output: Exception Message: "Employee Name NOT specified"
    public void testEmployee004() {

        try {
            Employee.validateName(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Employee Name NOT specified", e.getMessage());
        }

    }

    //Test #: 5
    //Test Objective: To catch an incorrect lower boundary value Employee Address
    //Inputs: EmployeeAddress = "At"
    //Expected Output: Exception Message: "Employee Address does not meet minimum length requirements"
    public void testEmployee005() {

        try {
            Employee.validateAddress("At");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Employee Address does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 6
    //Test Objective: To catch an incorrect Upper boundary value Employee Address
    //Inputs: EmployeeAddress = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    //Expected Output: Exception Message: "Employee Address exceeds maximum length requirements"
    public void testEmployee006() {

        try {
            Employee.validateAddress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Employee Address exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 7
    //Test Objective: To catch an empty value Employee Address
    //Inputs: EmployeeAddress = " "
    //Expected Output: Exception Message: "Employee Address NOT specified"
    public void testEmployee007() {

        try {
            Employee.validateAddress(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Employee Address NOT specified", e.getMessage());
        }

    }

    //Test #: 8
    //Test Objective: To catch an incorrect lower boundary value Employee PhoneNumber
    //Inputs: EmployeePhone = "083"
    //Expected Output: Exception Message: "Employee PhoneNumber does not meet minimum length requirements"
    public void testEmployee008() {

        try {
            Employee.validatePhoneNumber("083");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Employee PhoneNumber does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 9
    //Test Objective: To catch an incorrect Upper boundary value Employee PhoneNumber
    //Inputs: EmployeePhone = "888888888888888888888888888888888888888"
    //Expected Output: Exception Message: "Employee PhoneNumber exceeds maximum length requirements"
    public void testEmployee009() {

        try {
            Employee.validatePhoneNumber("888888888888888888888888888888888888888");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Employee PhoneNumber exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 10
    //Test Objective: To catch an empty value Employee PhoneNumber
    //Inputs: EmployeePhone = " "
    //Expected Output: Exception Message: "Employee PhoneNumber NOT specified"
    public void testEmployee010() {

        try {
            Employee.validatePhoneNumber(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Employee PhoneNumber NOT specified", e.getMessage());
        }

    }

}

