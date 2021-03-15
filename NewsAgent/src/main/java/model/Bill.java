package model;

import controller.DaoExceptionHandler;

/**
 * @ClassName Bill
 * @Description TODO
 * @Author Minjun Dai @Email A00279566@student.ait.ie
 * @Date 2021/3/14 17:41
 * @Version 1.0
 */
public class Bill {

    private int id;
    private String customerName;
    private String customerAddress;
    private double fee;
    private String date;

    public Bill() {

    }

    public Bill(String customerName, String customerAddress, double fee, String date) throws DaoExceptionHandler {
        try {
            validateCustomerName(customerName);
            validateCustomerAddress(customerAddress);
            validateDate(date);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            throw daoExceptionHandler;
        }
        setCustomerName(customerName);
        setCustomerAddress(customerAddress);
        setFee(fee);
        setDate(date);
    }

    public Bill(int id, String customerName, String customerAddress, double fee, String date) throws DaoExceptionHandler {
        try {
            validateCustomerName(customerName);
            validateCustomerAddress(customerAddress);
            validateDate(date);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            throw daoExceptionHandler;
        }
        setId(id);
        setCustomerName(customerName);
        setCustomerAddress(customerAddress);
        setFee(fee);
        setDate(date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", fee=" + fee +
                ", date='" + date + '\'' +
                '}';
    }

    public static void validateFee(double fee) throws DaoExceptionHandler {
        if (fee < 0) {
            throw new DaoExceptionHandler("Fee does not meet minimum length requirements");
        } else if (fee > 100000) {
            throw new DaoExceptionHandler("Fee does not meet maximum length requirements");
        }
    }


    public static void validateCustomerAddress(String customerAddress) throws DaoExceptionHandler {
        if (customerAddress.isEmpty() || customerAddress.isBlank()) {
            throw new DaoExceptionHandler("Customer Address NOT specified");
        } else if (customerAddress.length() < 10) {
            throw new DaoExceptionHandler("Customer Address does not meet minimum length requirements");
        } else if (customerAddress.length() > 25) {
            throw new DaoExceptionHandler("Customer Address exceeds maximum length requirements");
        }
    }

    public static void validateCustomerName(String customerName) throws DaoExceptionHandler {
        if ( customerName.isEmpty() || customerName.isBlank()) {
            throw new DaoExceptionHandler("Customer Name NOT specified");
        } else if (customerName.length() < 3) {
            throw new DaoExceptionHandler("Customer Name does not meet minimum length requirements");
        } else if (customerName.length() > 25) {
            throw new DaoExceptionHandler("Customer Name exceeds maximum length requirements");
        }
    }

    public static void validateDate(String deliverDate) throws DaoExceptionHandler {
        if (deliverDate.isEmpty() || deliverDate.isBlank())
            throw new DaoExceptionHandler("Bill NOT specified");
        else if (deliverDate.length() < 9)
            throw new DaoExceptionHandler("Bill Date does not meet minimum length requirements");
        else if (deliverDate.length() > 11)
            throw new DaoExceptionHandler("Bill Date does exceeds maximum length requirements");
    }

}
