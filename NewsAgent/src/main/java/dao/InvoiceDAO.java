package dao;

import model.Invoice;

import java.sql.Connection;
import java.util.List;

/**
 * @InterfaceName InvoiceDAO
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/4/5 16:27
 * @Version 1.0
 */
public interface InvoiceDAO {

    boolean insert(Connection conn, Invoice invoice);

    boolean deleteById(Connection conn, int id);

    boolean update(Connection conn, Invoice invoice);

    Invoice getInvoiceById(Connection conn, int id);

    List<Invoice> getAll(Connection conn);

}
