package model;

import controller.DaoExceptionHandler;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName Customer
 * @Description Customer bean
 * @Author Xiangyu Liu @Email A00279565@student.ait.ie
 * @Date 2021/2/11 01:59
 * @Version 1.0
 */
public class Publication {

    private int pid;
    private String pname;
    private double price;
    private int amount;

    public Publication() {

    }

    public Publication(String pname, double price, int amount) throws DaoExceptionHandler {
        try {
            validateName(pname);
            validateAmount(amount);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            throw daoExceptionHandler;
        }
        this.pname = pname;
        this.price = price;
        this.amount = amount;
    }

    public Publication(int pid, String pname, double price, int amount) throws DaoExceptionHandler {
        try {
            validateName(pname);
            validateAmount(amount);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            throw daoExceptionHandler;
        }
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.amount = amount;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    public static void validateName(String publicationrName) throws DaoExceptionHandler {
        if (publicationrName.isBlank() || publicationrName.isEmpty())
            throw new DaoExceptionHandler("Publication Name NOT specified");
        else if (publicationrName.length() < 2)
            throw new DaoExceptionHandler("Publication Name does not meet minimum length requirements");
        else if (publicationrName.length() > 45)
            throw new DaoExceptionHandler("Publication Name exceeds maximum length requirements");
    }


    public static void validateAmount(int publicationAmount) throws DaoExceptionHandler {
        if (publicationAmount < 0)
            throw new DaoExceptionHandler("Publication Amount does not meet minimum length requirements");
        else if (publicationAmount > 100000)
            throw new DaoExceptionHandler("Publication Amount exceeds maximum length requirements");
    }

}
