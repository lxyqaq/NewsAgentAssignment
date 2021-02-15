package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ClassName JDBCUtils
 * @Description Get database connection method and Close database resource method
 * @Author Xiangyu Liu @Email A00279565@student.ait.ie
 * @Date 2021/2/8 01:22
 * @Version 1.0
 */
public class JDBCUtils {

    /**
     * @description Use Druid database connection pool technology
     * @param null
     * @return null
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/8 01:30
     */
    private static DataSource source;

    static {
        try {
            Properties pros = new Properties();

            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");

            pros.load(is);

            source = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = source.getConnection();
        return conn;
    }

    /**
     * @param conn
     * @param ps
     * @description Operation of closing connection and Statement
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/8 23:02
     */
    public static void closeResource(Connection conn, Statement ps) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param conn
     * @param ps
     * @param rs
     * @description Close resource operation
     * @author Xiangyu Liu @email A00279565@student.ait.ie
     * @date 2021/2/8 23:45
     */
    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
