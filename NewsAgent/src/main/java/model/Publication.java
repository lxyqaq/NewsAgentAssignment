package model;

import controller.DaoExceptionHandler;

/**
 * @ClassName Publication
 * @Description Publication bean
 * @Author Xiangyu Liu @Email A00279565@student.ait.ie
 * @Date 2021/2/12 21:17
 * @Version 1.0
 */
public class Publication {

    private int id;
    private String name;
    private String amount;

    public Publication() {

    }

    public Publication(String name, String amount) throws DaoExceptionHandler {
        try {
            validateName(name);
            validateAmount(amount);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            daoExceptionHandler.printStackTrace();
        }
        this.name = name;
        this.amount = amount;
    }

    public Publication(int id, String name, String amount) throws DaoExceptionHandler {
        try {
            validateName(name);
            validateAmount(amount);
        } catch (DaoExceptionHandler daoExceptionHandler) {
            daoExceptionHandler.printStackTrace();
        }
        this.id = id;
        this.name = name;
        this.amount = amount;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
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

    /**
     * @param publicationrName
     * @return void
     * @throws
     * @description validate publicationrName
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/13 21:20
     */
    public static void validateName(String publicationrName) throws DaoExceptionHandler {
        if (publicationrName.isBlank() || publicationrName.isEmpty())
            throw new DaoExceptionHandler("Publication Name NOT specified");
        else if (publicationrName.length() < 2)
            throw new DaoExceptionHandler("Publication Name does not meet minimum length requirements");
        else if (publicationrName.length() > 45)
            throw new DaoExceptionHandler("Publication Name exceeds maximum length requirements");
    }

    /**
     * @param publicationAmount
     * @return void
     * @throws
     * @description validate publicationAmount
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/13 21:20
     */
    public static void validateAmount(String publicationAmount) throws DaoExceptionHandler {
        if (publicationAmount.isBlank() || publicationAmount.isEmpty())
            throw new DaoExceptionHandler("Publication Name NOT specified");
        else if (publicationAmount.length() < 1)
            throw new DaoExceptionHandler("Publication Name does not meet minimum length requirements");
        else if (publicationAmount.length() > 45)
            throw new DaoExceptionHandler("Publication Name exceeds maximum length requirements");
    }

}
