package dao;

import model.Bill;
import model.Customer;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName BillDAOImpl
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/3/14 18:00
 * @Version 1.0
 */
public class BillDAOImpl extends BaseDAO<Bill> implements BillDAO {

    @Override
    public boolean insert(Connection conn, Bill bill) {
        String sql = "insert into bill(customerName,customerAddress,fee,date)values(?,?,?,?)";
        boolean insert = update(conn, sql, bill.getCustomerName(), bill.getCustomerAddress(), bill.getFee(), bill.getDate());
        return insert;
    }

    @Override
    public boolean deleteById(Connection conn, int id) {
        String sql = "delete from bill where id = ?";
        boolean delete = update(conn, sql, id);
        return delete;
    }

    @Override
    public boolean update(Connection conn, Bill bill) {
        String sql = "update customer set customerName = ?,customerAddress = ?,fee = ?,date = ? where id = ?";
        boolean update = update(conn, sql, bill.getCustomerName(), bill.getCustomerAddress(), bill.getFee(), bill.getDate(), bill.getId());
        return update;
    }

    @Override
    public Bill getBillById(Connection conn, int id) {
        String sql = "select * from bill where id = ?";
        Bill bill = getInstance(conn, sql, id);
        return bill;
    }

    @Override
    public List<Bill> getAll(Connection conn) {
        String sql = "select * from bill";
        List<Bill> list = getForList(conn, sql);
        return list;
    }

}
