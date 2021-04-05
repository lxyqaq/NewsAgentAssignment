package model;

import controller.DaoExceptionHandler;


/**
 * @ClassName Customer
 * @Description Customer bean
 * @Author Xiangyu Liu @Email A00279565@student.ait.ie
 * @Date 2021/2/8 01:59
 * @Version 1.0
 */
public class Customer {

    private int cid;
    private String cname;
    private String cemail;
    private String caddress;
    private String cphone;

    public Customer() {

    }

    public Customer(String cname, String cemail, String caddress, String cphoneNumber) throws DaoExceptionHandler {
        try {
            validateName(cname);
            validateAddress(caddress);
            validatePhoneNumber(cphoneNumber);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            throw daoExceptionHandler;
        }
        setName(cname);
        setEmail(cemail);
        setAddresss(caddress);
        setPhoneNumber(cphoneNumber);
    }

    public Customer(int cid, String cname, String cemail, String caddress, String cphoneNumber) throws DaoExceptionHandler {
        try {
            validateName(cname);
            validateAddress(caddress);
            validatePhoneNumber(cphoneNumber);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            throw daoExceptionHandler;
        }
        setId(cid);
        setName(cname);
        setEmail(cemail);
        setAddresss(caddress);
        setPhoneNumber(cphoneNumber);
    }

    public int getId() {
        return cid;
    }

    public void setId(int id) {
        this.cid = id;
    }

    public String getName() {
        return cname;
    }

    public void setName(String name) {
        this.cname = name;
    }

    public String getEmail() {
        return cemail;
    }

    public void setEmail(String email) {
        this.cemail = email;
    }

    public String getAddress() {
        return caddress;
    }

    public void setAddresss(String address) {
        this.caddress = address;
    }

    public String getPhoneNumber() {
        return cphone;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.cphone = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + cid +
                ", name='" + cname + '\'' +
                ", email='" + cemail + '\'' +
                ", address='" + caddress + '\'' +
                ", phoneNumber='" + cphone + '\'' +
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

    public static void validateEmail(String email) throws DaoExceptionHandler {
        if (email.isBlank() || email.isEmpty())
            throw new DaoExceptionHandler("Customer Email NOT specified");
        else if (email.length() < 5)
            throw new DaoExceptionHandler("Customer Email does not meet minimum length requirements");
        else if (email.length() > 30)
            throw new DaoExceptionHandler("Customer Email exceeds maximum length requirements");
    }

}