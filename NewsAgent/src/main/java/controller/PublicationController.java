package controller;

import dao.PublicationDAO;
import dao.PublicationDAOImpl;
import model.Publication;
import utils.JDBCUtils;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;


public class PublicationController {

    private Scanner scanner = new Scanner(System.in);
    private PublicationDAO publicationDAO = new PublicationDAOImpl();

    // publicationDAO Method:
    public void Insert() {
        Connection conn = null;
        System.out.printf("Enter Publication Name: \n");
        String publicationName = scanner.next();
        System.out.printf("Enter Publication amount: \n");
        int publicationAmount = scanner.nextInt();
        try {
            conn = JDBCUtils.getConnection();
            Publication publi = new Publication(publicationName, publicationAmount);
            publicationDAO.insert(conn, publi);
            System.out.println("Added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void DeleteById() {
        Connection conn = null;
        System.out.printf("Enter Publication ID: \n");
        int publicationId = scanner.nextInt();
        try {
            conn = JDBCUtils.getConnection();
            publicationDAO.deleteById(conn, publicationId);
            System.out.println("Successfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void Update() {
        Connection conn = null;
        System.out.printf("Enter Publication ID: \n");
        int publicationId = scanner.nextInt();
        System.out.printf("Enter Publication Name: \n");
        String publicationName = scanner.next();
        System.out.printf("Enter Publication Amount: \n");
        int publicationAmount = scanner.nextInt();
        try {
            conn = JDBCUtils.getConnection();
            Publication publi = new Publication(publicationId, publicationName, publicationAmount);
            publicationDAO.update(conn, publi);
            System.out.println("Successfully modified");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void GetPublicationById() {
        Connection conn = null;
        System.out.printf("Enter Publication ID: \n");
        int publicationId = scanner.nextInt();
        try {
            conn = JDBCUtils.getConnection();
            Publication publi = publicationDAO.getPublicationById(conn, publicationId);
            System.out.println(publi);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    public void GetAll() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            List<Publication> list = publicationDAO.getAll(conn);
            list.forEach(System.out::println);
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

}
