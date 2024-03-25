/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.controller.register;

import dsd.socket.client.controller.MainController;
import dsd.socket.client.controller.base.BaseController;
import dsd.socket.client.infra.socket.WorkSocketClient;
import dsd.socket.client.view.ConnectionView;

/**
 *
 * @author Matheus
 */
public final class ConnectionController implements BaseController {

    private WorkSocketClient connection;
    private ConnectionView view;

    public ConnectionController() {
        this.view = new ConnectionView();
        this.view.setVisible(true);
        initButtons();
    }

    @Override
    public void initButtons() {
        view.addActionBtnConnect(((e) -> {
            connect();
        }));
    }

    public void connect() {
        try {
            if (verifyFields()) {
                String address = view.getAddress();
                Integer port = view.getPort();
                connection = WorkSocketClient.getInstance(address, port);
                connection.testConnection();
                showMessage("Connection successfully!", "Connected");
            } else {
                throw new Exception("Verify fields.");
            }

            closeFrame();
            var mainController = new MainController();
        } catch (Exception ex) {
            showMessage(ex.getMessage(), "Error");
        }
    }

    public boolean verifyFields() {
        return view.verifyFields();
    }

    @Override
    public void showFrame() {
        view.showFrame();
    }

    @Override
    public void closeFrame() {
        view.closeFrame();
    }

    @Override
    public void showMessage(String message, String title) {
        view.showMessage(message, title);
    }

}
