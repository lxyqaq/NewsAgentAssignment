package dao;

import model.Publication;

import java.sql.Connection;
import java.util.List;


public class PublicationDAOImpl extends BaseDAO<Publication> implements PublicationDAO {

    @Override
    public void insert(Connection conn, Publication publi) {
        String sql = "insert into publication(name,amount)values(?,?)";
        update(conn, sql, publi.getName(), publi.getAmount());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from publication where id = ?";
        update(conn, sql, id);
    }

    @Override
    public void update(Connection conn, Publication publi) {
        String sql = "update publication set name = ?,amount = ? where id = ?";
        update(conn, sql, publi.getName(), publi.getAmount(), publi.getId());
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
