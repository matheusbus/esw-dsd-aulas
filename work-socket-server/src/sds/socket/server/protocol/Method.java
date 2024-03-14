/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sds.socket.server.protocol;

/**
 *
 * @author matheus.buschermoehl
 */
public enum Method {

    GET,
    LIST,
    INSERT,
    UPDATE,
    DELETE;

    public static Method fromString(String value) {
        for (Method method : values()) {
            if (method.name().equalsIgnoreCase(value)) {
                return method;
            }
        }
        return null;
    }

}
