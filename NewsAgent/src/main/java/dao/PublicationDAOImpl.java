package dao;

import model.Publication;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName PublicationDAOImpl
 * @Description Override PublicationDAO method
 * @Author Xiangyu Liu @Email A00279565@student.ait.ie
 * @Date 2021/2/13 21:27
 * @Version 1.0
 */
public class PublicationDAOImpl extends BaseDAO<Publication> implements PublicationDAO {

    @Override
    public boolean insert(Connection conn, Publication publi) {
        String sql = "insert into publication(name,amount)values(?,?)";
        boolean insert = update(conn, sql, publi.getName(), publi.getAmount());
        return insert;
    }

    @Override
    public boolean deleteById(Connection conn, int id) {
        String sql = "delete from publication where id = ?";
        boolean delete = update(conn, sql, id);
        return delete;
    }

    @Override
    public boolean update(Connection conn, Publication publi) {
        String sql = "update publication set name = ?,amount = ? where id = ?";
        boolean update = update(conn, sql, publi.getName(), publi.getAmount(), publi.getId());
        return update;
    }

    @Override
    public Publication getPublicationById(Connection conn, int id) {
        String sql = "select id,name,amount from publication where id = ?";
        Publication publication = getInstance(conn, sql, id);
        return publication;
    }

    @Override
    public List<Publication> getAll(Connection conn) {
        String sql = "select * from publication";
        List<Publication> list = getForList(conn, sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from publication";
        return getValue(conn, sql);
    }

}
