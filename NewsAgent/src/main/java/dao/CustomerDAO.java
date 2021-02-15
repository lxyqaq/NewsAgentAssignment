package dao;

import model.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @ClassName CustomerDAO
 * @Description CustomerDAO interface
 * @Author Xiangyu Liu @Email A00279565@student.ait.ie
 * @Date 2021/2/8 02:00
 * @Version 1.0
 */
public interface CustomerDAO {

    /**
     * @param conn
     * @param cust
     * @return void
     * @throws
     * @description Add the cust object to the database
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/8 02:01
     */
    void insert(Connection conn, Customer cust);

    /**
     * @param conn
     * @param id
     * @return void
     * @throws
     * @description For the specified id, delete a record in the table
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/8 02:02
     */
    void deleteById(Connection conn, int id);

    /**
     * @param conn
     * @param cust
     * @return void
     * @throws
     * @description For the cust object in memory, modify the specified record in the data table
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/8 02:03
     */
    void update(Connection conn, Customer cust);

    /**
     * @param conn
     * @param id
     * @return model.Customer
     * @throws
     * @description Query the corresponding Customer object for the specified id
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/8 02:03
     */
    Customer getCustomerById(Connection conn, int id);

    /**
     * @param conn
     * @return java.util.List<model.Customer>
     * @throws
     * @description The set of all records in the query table
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/8 02:03
     */
    List<Customer> getAll(Connection conn);

    /**
     * @param conn
     * @return java.lang.Long
     * @throws
     * @description Returns the number of data entries in the data table
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/8 02:04
     */
    Long getCount(Connection conn);

}
