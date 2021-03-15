package model;

import controller.DaoExceptionHandler;

/**
 * @ClassName Order
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/3/14 17:31
 * @Version 1.0
 */
public class Order {

    private int id;
    private String customerName;
    private String publicationName;
    private String date;

    public Order() {

    }

    public Order(String customerName, String publicationName, String date) throws DaoExceptionHandler {
        try {
            validateName(customerName);
            validatePublication(publicationName);
            validateDate(date);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            throw daoExceptionHandler;
        }
        setCustomerName(customerName);
        setPublicationName(publicationName);
        setDate(date);
    }

    public Order(int id, String customerName, String publicationName, String date) throws DaoExceptionHandler {
        try {
            validateName(customerName);
            validatePublication(publicationName);
            validateDate(date);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            throw daoExceptionHandler;
        }
        setId(id);
        setCustomerName(customerName);
        setPublicationName(publicationName);
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

    public String getPublicationName() {
        return publicationName;
    }

    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", publicationName='" + publicationName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public static void validateName(String custName) throws DaoExceptionHandler {

        if (custName.isEmpty() || custName.isBlank())
            throw new DaoExceptionHandler("Customer Name NOT specified");
        else if (custName.length() < 2)
            throw new DaoExceptionHandler("Customer Name does not meet minimum length requirements");
        else if (custName.length() > 15)
            throw new DaoExceptionHandler("Customer Name exceeds maximum length requirements");

    }

    public static void validatePublication(String publicationName) throws DaoExceptionHandler {

        if (publicationName.isEmpty() || publicationName.isBlank())
            throw new DaoExceptionHandler("Publication Name NOT specified");
        else if (publicationName.length() < 2)
            throw new DaoExceptionHandler("Publication Name does not meet minimum length requirements");
        else if (publicationName.length() > 15)
            throw new DaoExceptionHandler("Publication Name exceeds maximum length requirements");

    }

    public static void validateDate(String deliverDate) throws DaoExceptionHandler {

        if (deliverDate.isEmpty() || deliverDate.isBlank())
            throw new DaoExceptionHandler("Deliver Date NOT specified");
        else if (deliverDate.length() < 8)
            throw new DaoExceptionHandler("Deliver Date does not meet minimum length requirements");
        else if (deliverDate.length() > 10)
            throw new DaoExceptionHandler("Deliver Date exceeds maximum length requirements");

    }

}
