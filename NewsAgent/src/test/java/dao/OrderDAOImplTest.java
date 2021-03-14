package dao;

import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName OrderDAOImplTest
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/3/14 20:37
 * @Version 1.0
 */
public class OrderDAOImplTest {

    @Test
    public void test() throws SQLException {

        Connection connection = JDBCUtils.getConnection();

        OrderDAO orderDAO = new OrderDAOImpl();

        orderDAO.getAll(connection);

    }

}
