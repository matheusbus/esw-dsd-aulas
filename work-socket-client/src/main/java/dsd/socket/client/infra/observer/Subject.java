/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.infra.observer;

/**
 *
 * @author matheus
 */
public interface Subject {
    
    void registerObserver(RequestObserver obs);
    void removeObserver(RequestObserver obs);
    void notifyObservers(String message);
    
}
