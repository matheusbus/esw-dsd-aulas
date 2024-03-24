/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.infra.socket;

import dsd.socket.client.infra.request.Request;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Matheus
 */
public class WorkSocketClient {

    private static WorkSocketClient instance;

    private String address;
    private Integer port;

    public static WorkSocketClient getInstance(String address, Integer port) {
        if (instance == null) {
            instance = new WorkSocketClient(address, port);
        }
        return instance;
    }

    public static WorkSocketClient getInstance() {
        return instance;
    }

    private WorkSocketClient(String address, Integer port) {
        this.address = address;
        this.port = port;
    }

    public void testConnection() throws IOException {
        Socket socket = new Socket(address, port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Handshake message.");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String response = in.readLine();
        System.out.println("Resposta do servidor: " + response);
        in.close();
        out.close();
    }

    public void sendRequest(Request request) {
        try {
            try (Socket socket = new Socket(address, port)) {

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(request.toString());
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String response = in.readLine();
                request.setResponse(response);

                System.out.println("Resposta do servidor: " + response);

                in.close();
                out.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
