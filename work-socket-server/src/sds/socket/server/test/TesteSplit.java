/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sds.socket.server.test;

/**
 *
 * @author matheus.buschermoehl
 */
public class TesteSplit {
    
    public static void main(String[] args) {
        
        String message = "GET;11317376951;MATHEUS;04/07/2002";
        String message_split[] = message.split(";");
        
        for (String m : message_split) {
            System.out.println(m);
        }
    }
    
    
}
