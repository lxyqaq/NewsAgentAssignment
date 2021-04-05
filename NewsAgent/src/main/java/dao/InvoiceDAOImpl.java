package dao;

import model.Invoice;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName InvoiceDAOImpl
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/4/5 16:28
 * @Version 1.0
 */
public class InvoiceDAOImpl extends BaseDAO<Invoice> implements InvoiceDAO {

    @Override
    public boolean insert(Connection conn, Invoice invoice) {
        String sql = "insert into invoice(cname,pname,quantity,caddress,odate,total)values(?,?,?,?,?,?)";
        boolean insert = update(conn, sql, invoice.getCname(), invoice.getPname(), invoice.getQuantity(), invoice.getCaddress(), invoice.getOdate(), invoice.getTotal());
        return insert;
    }

    @Override
    public boolean deleteById(Connection conn, int id) {
        String sql = "delete from invoice where iid = ?";
        boolean delete = update(conn, sql, id);
        return delete;
    }

    @Override
    public boolean update(Connection conn, Invoice invoice) {
        String sql = "update invoice set cname = ?,pname = ?,quantity = ?,caddress = ?,odate = ?,total = ? where iid = ?";
        boolean update = update(conn, sql, invoice.getCname(), invoice.getPname(), invoice.getQuantity(), invoice.getCaddress(), invoice.getOdate(), invoice.getTotal(), invoice.getIid());
        return update;
    }

    @Override
    public Invoice getInvoiceById(Connection conn, int id) {
        String sql = "select * from invoice where iid = ?";
        Invoice invoice = getInstance(conn, sql, id);
        return invoice;
    }

    @Override
    public List<Invoice> getAll(Connection conn) {
        String sql = "select * from invoice";
        List<Invoice> list = getForList(conn, sql);
        return list;
    }

}
