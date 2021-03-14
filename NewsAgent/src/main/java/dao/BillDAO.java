package dao;

import model.Bill;
import model.Order;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName BillDAO
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/3/14 17:59
 * @Version 1.0
 */
public interface BillDAO {

    boolean insert(Connection conn, Bill bill);

    boolean deleteById(Connection conn, int id);

    boolean update(Connection conn, Bill bill);

    Bill getBillById(Connection conn, int id);

    List<Bill> getAll(Connection conn);

}
