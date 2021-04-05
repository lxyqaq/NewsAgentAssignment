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

    private int bid;
    private int oid;
    private String cname;
    private String caddress;
    private String cphone;
    private double fee;
    private String odate;

    public Bill() {

    }

    public Bill(int oid, String cname, String caddress, String cphone, double fee, String odate) throws DaoExceptionHandler {
        try {
            validateCustomerName(cname);
            validateCustomerAddress(caddress);
            validateDate(odate);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            throw daoExceptionHandler;
        }
        this.oid = oid;
        this.cname = cname;
        this.caddress = caddress;
        this.cphone = cphone;
        this.fee = fee;
        this.odate = odate;
    }

    public Bill(int bid, int oid, String cname, String caddress, String cphone, double fee, String odate) throws DaoExceptionHandler {
        try {
            validateCustomerName(cname);
            validateCustomerAddress(caddress);
            validateDate(odate);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            throw daoExceptionHandler;
        }
        this.bid = bid;
        this.oid = oid;
        this.cname = cname;
        this.caddress = caddress;
        this.cphone = cphone;
        this.fee = fee;
        this.odate = odate;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
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

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getOdate() {
        return odate;
    }

    public void setOdate(String odate) {
        this.odate = odate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bid=" + bid +
                ", oid=" + oid +
                ", cname='" + cname + '\'' +
                ", caddress='" + caddress + '\'' +
                ", cphone='" + cphone + '\'' +
                ", fee=" + fee +
                ", odate='" + odate + '\'' +
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
        } else if (customerAddress.length() < 2) {
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
