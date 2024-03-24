package dsd.socket.server;

import dsd.socket.request.RequestHandler;
import dsd.socket.request.RequestHandlerException;
import org.h2.tools.Server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

/**
 *
 * @author matheus.buschermoehl
 */
public class WorkSocketServer {

    private static WorkSocketServer instance;
    private RequestHandler requestHandler;

    static {
        try {
            Server.createWebServer("-webPort", "9092").start();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static WorkSocketServer getInstance() {
        if(instance == null) {
            instance = new WorkSocketServer();
        }
        return instance;
    }

    private WorkSocketServer() {
        this.requestHandler = RequestHandler.getInstance();
    }

    public void start(Integer port) throws IOException {
        ServerSocket serverSocket = null;
        try {
            // MUDAR OS SYSTEM.OUT.PRINT PARA LOG4J
            serverSocket = new ServerSocket(port);
            System.out.println("Listening on <"+InetAddress.getLocalHost().getHostAddress()+":"+serverSocket.getLocalPort()+">");
            System.out.println("Server waiting for requests...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection established with client <"+clientSocket.getInetAddress()+":"+clientSocket.getLocalPort()+">");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String request = in.readLine();
                System.out.println("Request received from client <"+clientSocket.getInetAddress()+">: " + request);

                try {
                    Object response;
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                    if(!request.equals("Handshake message.")) {
                        response = requestHandler.handleRequest(request);

                        // Enviar resposta para o cliente
                        out.println(response.toString());
                    } else {
                        out.println("Connection successfully!");
                    }

                    // Fechar recursos
                    out.close();
                    in.close();
                    clientSocket.close();
                } catch (RequestHandlerException ex) {
                    System.out.println(ex.getMessage());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket != null) serverSocket.close();
        }
    }
    
}
