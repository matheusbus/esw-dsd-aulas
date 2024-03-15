package dsd.socket;

import dsd.socket.server.WorkSocketServer;

public class App {

    public static void main(String[] args) {
        WorkSocketServer.getInstance().start(12345);
    }

}
