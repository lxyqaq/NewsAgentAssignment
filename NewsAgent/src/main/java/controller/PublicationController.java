package controller;

import dao.PublicationDAO;
import dao.PublicationDAOImpl;
import model.Publication;
import utils.JDBCUtils;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;


/**
 * @ClassName PublicationController
 * @Description PublicationController database CRUD method
 * @Author Xiangyu Liu @Email A00279565@student.ait.ie
 * @Date 2021/2/13 21:38
 * @Version 1.0
 */
public class PublicationController {

    private Scanner scanner = new Scanner(System.in);
    private PublicationDAO publicationDAO = new PublicationDAOImpl();

    // publicationDAO Method:
    public void Insert() {
        Connection conn = null;
        System.out.printf("Enter Publication Name: \n");
        String publicationName = scanner.next();
        System.out.printf("Enter Publication Price: \n");
        double publicationPrice = scanner.nextDouble();
        System.out.printf("Enter Publication amount: \n");
        int publicationAmount = scanner.nextInt();
        try {
            conn = JDBCUtils.getConnection();
            Publication publi = new Publication(publicationName, publicationPrice, publicationAmount);
            boolean insert = publicationDAO.insert(conn, publi);
            if (insert == true) {
                System.out.println("Employee Details Saved");
            } else {
                System.out.println("ERROR: Employee Details NOT Saved");
            }
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
            boolean delete = publicationDAO.deleteById(conn, publicationId);
            if (delete == true) {
                System.out.println("Publication Deleted");
            } else {
                System.out.println("ERROR: Publication Details NOT Deleted or Do Not Exist");
            }
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
        System.out.printf("Enter Publication Price: \n");
        double publicationPrice = scanner.nextDouble();
        System.out.printf("Enter Publication Amount: \n");
        int publicationAmount = scanner.nextInt();
        try {
            conn = JDBCUtils.getConnection();
            Publication publi = new Publication(publicationId, publicationName, publicationPrice, publicationAmount);
            boolean update = publicationDAO.update(conn, publi);
            if (update == true) {
                System.out.println("Publication Updated");
            } else {
                System.out.println("ERROR: Publication Details NOT Updated or Do Not Exist");
            }
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
            System.out.println("This ID does not exist");
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
