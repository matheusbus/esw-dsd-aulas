/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.infra.request;

import dsd.socket.client.infra.socket.WorkSocketClient;

/**
 *
 * @author Matheus
 */
public abstract class Request {

    protected WorkSocketClient socket;
    protected String request;
    protected String response;

    public Request() {
        socket = WorkSocketClient.getInstance();
    }

    public Request append(String value) {
        if (request.isEmpty()) {
            this.request = value + ";";
        } else {
            this.request = this.request + ";" + value;
        }
        return this;
    }

    public final void send() {
        socket.sendRequest(this);
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return this.request;
    }
    
    

}
