/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sds.socket.server.protocol;

/**
 *
 * @author matheus.buschermoehl
 */
public enum Subject {

    COMPANY,
    CUSTOMER,
    EMPLOYEE;

    public static Subject fromString(String value) {
        for (Subject subject : values()) {
            if (subject.name().equalsIgnoreCase(value)) {
                return subject;
            }
        }
        return null;
    }

}
