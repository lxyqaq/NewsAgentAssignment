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

    private int id;
    private String name;
    private int amount;

    public Publication() {

    }

    public Publication(String name, int amount) throws DaoExceptionHandler {
        try {
            validateName(name);
            validateAmount(amount);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            daoExceptionHandler.printStackTrace();
        }
        setName(name);
        setAmount(amount);
    }

    public Publication(int id, String name, int amount) throws DaoExceptionHandler {
        try {
            validateName(name);
            validateAmount(amount);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            daoExceptionHandler.printStackTrace();
        }
        setId(id);
        setName(name);
        setAmount(amount);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }


    public static void validateName(String publicationrName) throws DaoExceptionHandler {
        if (StringUtils.isBlank(publicationrName))
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
