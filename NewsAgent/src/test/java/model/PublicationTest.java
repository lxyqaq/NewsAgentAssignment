package model;

import controller.DaoExceptionHandler;
import junit.framework.TestCase;


public class PublicationTest extends TestCase {

    //Test #: 1
    //Test Objective: To create a Publication information
    //Inputs: PublicationName = "Test", PublicationAmount = 11
    //Expected Output: Publication Object created with id = 0, "Test", PublicationAmount = 11,
    public void testCustomer001() {

        try {
            Publication publication001 = new Publication("Test", 11);
            assertEquals(0, publication001.getId());
            assertEquals("Test", publication001.getName());
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
    //Test Objective: To catch an incorrect lower boundary value Publication Amount
    //Inputs: PublicationAmount = -1
    //Expected Output: Exception Message: "Customer Address does not meet minimum length requirements"
    public void testCustomer005() {

        try {
            Publication.validateAmount(-1);
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Publication Amount NOT specified", e.getMessage());
        }

    }

    //Test #: 6
    //Test Objective: To catch an incorrect Upper boundary value Publication Amount
    //Inputs: PublicationAmount = 0
    //Expected Output: Exception Message: "Publication Amount does not meet minimum length requirements"
    public void testCustomer006() {

        try {
            Publication.validateAmount(0);
            fail("Exception expected");
        } catch (DaoExceptionHandler e) {
            assertEquals("Publication Amount does not meet minimum length requirements", e.getMessage());
        }

    }

}
