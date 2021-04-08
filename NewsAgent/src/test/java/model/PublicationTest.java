
package model;

import controller.DaoExceptionHandler;
import junit.framework.TestCase;


/**
 * @ClassName PublicationTest
 * @Description Publication Test Coverage
 * @Author Xiangyu Liu @Email A00279565@student.ait.ie
 * @Date 2021/2/13 21:57
 * @Version 1.0
 */

public class PublicationTest extends TestCase {

    //Test #: 1
    //Test Objective: To create a Publication information
    //Inputs: PublicationName = "Test", PublicationAmount = 11
    //Expected Output: Publication Object created with id = 0, "Test", PublicationAmount = 11,
    public void testPublication001() {

        try {
            Publication publication001 = new Publication("newspaper", 150, 1000);
            assertEquals(0, publication001.getPid());
            assertEquals("Test", publication001.getPname());
            assertEquals(11, publication001.getAmount());
        } catch (DaoExceptionHandler e) {
            fail("Exception not expected");
        }

    }

    //Test #: 2
    //Test Objective: To catch an incorrect lower boundary value Publication name
    //Inputs: PublicationName = "J"
    //Expected Output: Exception Message: "Publication Name does not meet minimum length requirements"
    public void testPublication002() {

        try {
            Publication.validateName("J");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Publication Name does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 3
    //Test Objective: To catch an incorrect Upper boundary value Publication name
    //Inputs: PublicationName = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    //Expected Output: Exception Message: "Publication Name exceeds maximum length requirements"
    public void testPublication003() {

        try {
            Publication.validateName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Publication Name exceeds maximum length requirements", e.getMessage());
        }

    }

    //Test #: 4
    //Test Objective: To catch an empty value Publication Name
    //Inputs: PublicationName = " "
    //Expected Output: Exception Message: "Publication Name NOT specified"
    public void testPublication004() {

        try {
            Publication.validateName(" ");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Publication Name NOT specified", e.getMessage());
        }

    }

    //Test #: 5
    //Test Objective: To catch an empty value Publication Name
    //Inputs: PublicationName = ""
    //Expected Output: Exception Message: "Publication Name NOT specified"
    public void testPublication005() {

        try {
            Publication.validateName("");
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Publication Name NOT specified", e.getMessage());
        }

    }


    //Test #: 7
    //Test Objective: To catch an incorrect lower boundary value Publication Amount
    //Inputs: PublicationAmount = -1
    //Expected Output: Exception Message: "Publication Amount does not meet minimum length requirements"
    public void testPublication007() {

        try {
            Publication.validateAmount(-1);
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Publication Amount does not meet minimum length requirements", e.getMessage());
        }

    }

    //Test #: 8
    //Test Objective: To catch an incorrect Upper boundary value Publication Amount
    //Inputs: PublicationAmount = 0
    //Expected Output: Exception Message: "Publication Amount does not meet minimum length requirements"
    public void testPublication008() {

        try {
            Publication publication007 = new Publication("newspaper", 150, 0);
            assertEquals(0, publication007.getAmount());
        } catch (DaoExceptionHandler e) {
            fail("Exception expected");
        }

    }

    //Test #: 9
    //Test Objective: To catch an incorrect Upper boundary value Publication Amount
    //Inputs: PublicationAmount = 100000
    //Expected Output: PublicationAmount = 100000
    public void testPublication009() {

        try {
            Publication publication007 = new Publication("newspaper", 150, 10000);
            assertEquals(100000, publication007.getAmount());
        } catch (DaoExceptionHandler e) {
            fail("Exception expected");
        }

    }

    //Test #: 10
    //Test Objective: To catch an incorrect Upper boundary value Publication Amount
    //Inputs: PublicationAmount = 100001
    //Expected Output: Exception Message: "Publication Amount exceeds maximum length requirements"
    public void testPublication010() {

        try {
            Publication.validateAmount(100001);
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Publication Amount exceeds maximum length requirements", e.getMessage());
        }

    }

}

