package model;

import controller.DaoExceptionHandler;

import java.sql.Date;


public class Employee {

    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public Employee() {

    }

    public Employee(String name, String email, String address, String phoneNumber) throws DaoExceptionHandler {
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

    public Employee(int id, String name, String email, String address, String phoneNumber) throws DaoExceptionHandler {
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
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
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
        if (employeeAddr.isBlank() || employeeAddr.isEmpty())
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

