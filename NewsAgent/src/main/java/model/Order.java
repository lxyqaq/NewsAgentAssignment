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

    private int oid;
    private String cname;
    private String cemail;
    private String caddress;
    private String cphone;
    private String pname;
    private double price;
    private int quantity;
    private String odate;

    public Order() {

    }

    public Order(String cname, String cemail, String caddress, String cphone, String pname, double price, int quantity, String odate) throws DaoExceptionHandler {
        try {
            validateName(cname);
            validatePublication(pname);
            validateDate(odate);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            throw daoExceptionHandler;
        }
        this.cname = cname;
        this.cemail = cemail;
        this.caddress = caddress;
        this.cphone = cphone;
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
        this.odate = odate;
    }

    public Order(int oid, String cname, String cemail, String caddress, String cphone, String pname, double price, int quantity, String odate) throws DaoExceptionHandler {
        try {
            validateName(cname);
            validatePublication(pname);
            validateDate(odate);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            throw daoExceptionHandler;
        }
        this.oid = oid;
        this.cname = cname;
        this.cemail = cemail;
        this.caddress = caddress;
        this.cphone = cphone;
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
        this.odate = odate;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOdate() {
        return odate;
    }

    public void setOdate(String odate) {
        this.odate = odate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", cname='" + cname + '\'' +
                ", cemail='" + cemail + '\'' +
                ", caddress='" + caddress + '\'' +
                ", cphone='" + cphone + '\'' +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", odate='" + odate + '\'' +
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
