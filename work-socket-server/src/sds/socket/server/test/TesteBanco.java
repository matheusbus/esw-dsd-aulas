/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sds.socket.server.test;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
