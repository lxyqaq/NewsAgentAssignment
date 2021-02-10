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

    public void testCustomer001() {

        try {
            Customer customer001 = new Customer("Jack", "jack@gmail.com", "Athlone", "0830120548");
            assertEquals(0, customer001.getId());
            assertEquals("Jack", customer001.getName());
            assertEquals("jack@gmail.com", customer001.getEmail());
            assertEquals("Athlone", customer001.getAddress());
            assertEquals("0830120548", customer001.getPhoneNumber());
        } catch (DaoExceptionHandler e) {
            fail("Exception not expected");
        }

    }

    public void testCustomer002() {



    }

}
