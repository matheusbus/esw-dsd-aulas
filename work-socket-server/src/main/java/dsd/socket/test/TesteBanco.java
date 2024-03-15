package dsd.socket.test;

import java.sql.SQLException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.h2.tools.Server;

/**
 *
 * @author matheus.buschermoehl
 */
public class TesteBanco {

    public static void main(String[] args) throws SQLException {
        Server.createWebServer("-webPort", "9092").start();
        
        EntityManagerFactory h2EntityManagerFactory = Persistence.createEntityManagerFactory("h2Unit");
        EntityManager h2EntityManager = h2EntityManagerFactory.createEntityManager();

        // Use o EntityManager para operações com o H2
        h2EntityManager.close();
        h2EntityManagerFactory.close();

    }

}
