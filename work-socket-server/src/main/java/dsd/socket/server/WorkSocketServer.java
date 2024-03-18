package dsd.socket.server;

import dsd.socket.request.RequestHandler;
import dsd.socket.request.RequestHandlerException;
import org.h2.tools.Server;

import java.io.*;
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

    public void start(Integer port) {
        try {
            // MUDAR OS SYSTEM.OUT.PRINT PARA LOG4J
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server waiting for requests...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection established with client <"+clientSocket.getInetAddress()+">");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String request = in.readLine();
                System.out.println("Request received from client <"+clientSocket.getInetAddress()+">: " + request);

                try {
                    Object response = requestHandler.handleRequest(request);

                    // Fluxo de saída para enviar resposta para o cliente
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    // Enviar resposta para o cliente
                    out.println("Mensagem recebida com sucesso!");

                    // Enviar objeto
//                    ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
//                    out.writeObject(response);
//                    out.flush();

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
        }
    }

    public static void main(String[] args) {
        /*
        // 1- RequestHandler.openServices(); --> vai criar todos os serviços
        
        // 2- Cria o socket
        
        // 3- Aguardar por conexão
        
        while(true) {
            // Esperar conexão
            // Esperar mensagem
            // Recebe mensagem e chama --> RequestHandler.handleRequest(String request);
            // Recebe devolutiva --> if RequestHandler.responseAvailable() then getResponse(); e envia ao client
            // Finaliza conexão;
        }
        
        // 4- Fechar tudo;
        
        */
    }
    
}
