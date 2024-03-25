/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.infra.socket;

import dsd.socket.client.infra.observer.RequestObserver;
import dsd.socket.client.infra.observer.Subject;
import dsd.socket.client.infra.request.Request;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class WorkSocketClient implements Subject {

    private static WorkSocketClient instance;
    private List<RequestObserver> observers = new ArrayList<>();

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
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        
        Socket socket = new Socket(address, port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Handshake message.");
        notifyObservers("<Message sent - " + formattedDateTime + "> " + "Handshake message.");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String response = in.readLine();
        notifyObservers("<Response received - " + formattedDateTime + "> " + response);

        System.out.println("Resposta do servidor: " + response);
        in.close();
        out.close();
    }

    public void sendRequest(Request request) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        try {
            try (Socket socket = new Socket(address, port)) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(request.toString());
                notifyObservers("<Message sent - " + formattedDateTime + "> " + request.toString());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String response = in.readLine();
                request.setResponse(response);
                notifyObservers("<Response received - " + formattedDateTime + "> " + response);

                System.out.println("Resposta do servidor: " + response);

                in.close();
                out.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void registerObserver(RequestObserver obs) {
        this.observers.add(obs);
    }

    @Override
    public void removeObserver(RequestObserver obs) {
        this.observers.remove(obs);
    }

    @Override
    public void notifyObservers(String message) {
        for (RequestObserver obs : observers) {
            obs.update(message);
        }
    }

}
