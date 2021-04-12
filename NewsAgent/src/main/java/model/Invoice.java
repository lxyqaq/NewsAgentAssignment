package model;

import controller.DaoExceptionHandler;

/**
 * @ClassName Invoice
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/4/5 16:08
 * @Version 1.0
 */
public class Invoice {

    private int iid;
    private String cname;
    private String pname;
    private int quantity;
    private String caddress;
    private String odate;
    private double total;

    public Invoice() {

    }

    public Invoice(String cname, String pname, int quantity, String caddress, String odate, double total) throws DaoExceptionHandler {
        try {
            validateName(cname);
            validatePublication(pname);
            validateDate(odate);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            throw daoExceptionHandler;
        }
        this.cname = cname;
        this.pname = pname;
        this.quantity = quantity;
        this.caddress = caddress;
        this.odate = odate;
        this.total = total;
    }

    public Invoice(int iid, String cname, String pname, int quantity, String caddress, String odate, double total) throws DaoExceptionHandler {
        try {
            validateName(cname);
            validatePublication(pname);
            validateDate(odate);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            throw daoExceptionHandler;
        }
        this.iid = iid;
        this.cname = cname;
        this.pname = pname;
        this.quantity = quantity;
        this.caddress = caddress;
        this.odate = odate;
        this.total = total;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getOdate() {
        return odate;
    }

    public void setOdate(String odate) {
        this.odate = odate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "iid=" + iid +
                ", cname='" + cname + '\'' +
                ", pname='" + pname + '\'' +
                ", quantity=" + quantity +
                ", caddress='" + caddress + '\'' +
                ", odate='" + odate + '\'' +
                ", total=" + total +
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
