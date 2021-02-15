package model;

import controller.DaoExceptionHandler;

import java.sql.Date;

/**
 * @ClassName Customer
 * @Description Customer bean
 * @Author Xiangyu Liu @Email A00279565@student.ait.ie
 * @Date 2021/2/8 01:59
 * @Version 1.0
 */
public class Customer {

    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public Customer() {

    }

    public Customer(String name, String email, String address, String phoneNumber) throws DaoExceptionHandler {
        try {
            validateName(name);
            validateAddress(address);
            validatePhoneNumber(phoneNumber);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            daoExceptionHandler.printStackTrace();
        }
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Customer(int id, String name, String email, String address, String phoneNumber) throws DaoExceptionHandler {
        try {
            validateName(name);
            validateAddress(address);
            validatePhoneNumber(phoneNumber);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            daoExceptionHandler.printStackTrace();
        }
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddresss(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    /**
     * @param customerName
     * @return void
     * @throws
     * @description validate customer name
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/9 18:47
     */
    public static void validateName(String customerName) throws DaoExceptionHandler {
        if (customerName.isBlank() || customerName.isEmpty())
            throw new DaoExceptionHandler("Customer Name NOT specified");
        else if (customerName.length() < 2)
            throw new DaoExceptionHandler("Customer Name does not meet minimum length requirements");
        else if (customerName.length() > 45)
            throw new DaoExceptionHandler("Customer Name exceeds maximum length requirements");
    }

    /**
     * @param customerAddr
     * @return void
     * @throws
     * @description validate customer address
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/9 18:48
     */
    public static void validateAddress(String customerAddr) throws DaoExceptionHandler {
        if (customerAddr.isBlank() || customerAddr.isEmpty())
            throw new DaoExceptionHandler("Customer Address NOT specified");
        else if (customerAddr.length() < 5)
            throw new DaoExceptionHandler("Customer Address does not meet minimum length requirements");
        else if (customerAddr.length() > 45)
            throw new DaoExceptionHandler("Customer Address exceeds maximum length requirements");
    }

    /**
     * @param customerPhone
     * @return void
     * @throws
     * @description validate customer phone number
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/9 18:48
     */
    public static void validatePhoneNumber(String customerPhone) throws DaoExceptionHandler {
        if (customerPhone.isBlank() || customerPhone.isEmpty())
            throw new DaoExceptionHandler("Customer PhoneNumber NOT specified");
        else if (customerPhone.length() < 7)
            throw new DaoExceptionHandler("Customer PhoneNumber does not meet minimum length requirements");
        else if (customerPhone.length() > 15)
            throw new DaoExceptionHandler("Customer PhoneNumber exceeds maximum length requirements");
    }

}