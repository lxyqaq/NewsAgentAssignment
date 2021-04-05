package model;

import controller.DaoExceptionHandler;
import org.apache.commons.lang3.StringUtils;

import java.sql.Date;

/**
 * @ClassName Employee
 * @Description Override EmployeeDAO method
 * @Author Minjun Dai @Email A00279566@student.ait.ie
 * @Date 2021/2/14 02:06
 * @Version 1.0
 */

public class Employee {

    private int eid;
    private String ename;
    private String eemail;
    private String eaddress;
    private String ephoneNumber;

    public Employee() {

    }

    public Employee(String ename, String eemail, String eaddress, String ephoneNumber) throws DaoExceptionHandler {
        try {
            validateName(ename);
            validateAddress(eaddress);
            validatePhoneNumber(ephoneNumber);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            daoExceptionHandler.printStackTrace();
        }
        setName(ename);
        setEmail(eemail);
        setAddresss(eaddress);
        setPhoneNumber(ephoneNumber);
    }

    public Employee(int eid, String ename, String eemail, String eaddress, String ephoneNumber) throws DaoExceptionHandler {
        try {
            validateName(ename);
            validateAddress(eaddress);
            validatePhoneNumber(ephoneNumber);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            daoExceptionHandler.printStackTrace();
        }
        setId(eid);
        setName(ename);
        setEmail(eemail);
        setAddresss(eaddress);
        setPhoneNumber(ephoneNumber);
    }

    public int getId() {
        return eid;
    }

    public void setId(int id) {
        this.eid = id;
    }

    public String getName() {
        return ename;
    }

    public void setName(String name) {
        this.ename = name;
    }

    public String getEmail() {
        return eemail;
    }

    public void setEmail(String email) {
        this.eemail = email;
    }

    public String getAddress() {
        return eaddress;
    }

    public void setAddresss(String address) {
        this.eaddress = address;
    }

    public String getPhoneNumber() {
        return ephoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.ephoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + eid +
                ", name='" + ename + '\'' +
                ", email='" + eemail + '\'' +
                ", address='" + eaddress + '\'' +
                ", phoneNumber='" + ephoneNumber + '\'' +
                '}';
    }


    public static void validateName(String employeeName) throws DaoExceptionHandler {
        if (employeeName.isBlank() || employeeName.isEmpty())
            throw new DaoExceptionHandler("Employee Name NOT specified");
        else if (employeeName.length() < 2)
            throw new DaoExceptionHandler("Employee Name does not meet minimum length requirements");
        else if (employeeName.length() > 45)
            throw new DaoExceptionHandler("Employee Name exceeds maximum length requirements");
    }


    public static void validateAddress(String employeeAddr) throws DaoExceptionHandler {
        if (employeeAddr.isEmpty() || employeeAddr.isBlank())
            throw new DaoExceptionHandler("Employee Address NOT specified");
        else if (employeeAddr.length() < 5)
            throw new DaoExceptionHandler("Employee Address does not meet minimum length requirements");
        else if (employeeAddr.length() > 45)
            throw new DaoExceptionHandler("Employee Address exceeds maximum length requirements");
    }


    public static void validatePhoneNumber(String employeePhone) throws DaoExceptionHandler {
        if (employeePhone.isBlank() || employeePhone.isEmpty())
            throw new DaoExceptionHandler("Employee PhoneNumber NOT specified");
        else if (employeePhone.length() < 7)
            throw new DaoExceptionHandler("Employee PhoneNumber does not meet minimum length requirements");
        else if (employeePhone.length() > 15)
            throw new DaoExceptionHandler("Employee PhoneNumber exceeds maximum length requirements");
    }

}

