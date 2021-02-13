package dao;

import model.Publication;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName PublicationDAO
 * @Description TODO
 * @Author Xiangyu Liu @Email A00279565@student.ait.ie
 * @Date 2021/2/13 21:21
 * @Version 1.0
 */
public interface PublicationDAO {

    /**
     * @param conn
     * @param publi
     * @return void
     * @throws
     * @description insert method
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/13 21:23
     */
    void insert(Connection conn, Publication publi);

    /**
     * @param conn
     * @param id
     * @return void
     * @throws
     * @description delete method by id
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/13 21:23
     */
    void deleteById(Connection conn, int id);

    /**
     * @param conn
     * @param publi
     * @return void
     * @throws
     * @description update method
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/13 21:24
     */
    void update(Connection conn, Publication publi);

    /**
     * @param conn
     * @param id
     * @return model.Customer
     * @throws
     * @description get publication by id
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/13 21:24
     */
    Publication getPublicationById(Connection conn, int id);

    /**
     * @param conn
     * @return java.util.List<model.Customer>
     * @throws
     * @description get all method
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/13 21:24
     */
    List<Publication> getAll(Connection conn);

    /**
     * @param conn
     * @return java.lang.Long
     * @throws
     * @description get count
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/13 21:25
     */
    Long getCount(Connection conn);

}
