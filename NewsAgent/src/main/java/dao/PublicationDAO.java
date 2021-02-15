package dao;

import model.Publication;

import java.sql.Connection;
import java.util.List;


public interface PublicationDAO {


    void insert(Connection conn, Publication publi);


    void deleteById(Connection conn, int id);


    void update(Connection conn, Publication publi);


    Publication getPublicationById(Connection conn, int id);


    List<Publication> getAll(Connection conn);


    Long getCount(Connection conn);

}
