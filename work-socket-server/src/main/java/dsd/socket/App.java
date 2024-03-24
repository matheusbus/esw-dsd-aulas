package dsd.socket;

import dsd.socket.server.WorkSocketServer;

import java.io.IOException;

public class App {

    public static void main(String[] args) {
        try {
            WorkSocketServer.getInstance().start(12345);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
