/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.infra.request.method;

/**
 *
 * @author Matheus
 */
public enum CompanyMethod {

    GET,
    LIST,
    INSERT,
    UPDATE,
    DELETE,
    PAYROLL;

    public static CompanyMethod fromString(String value) {
        for (CompanyMethod method : values()) {
            if (method.name().equalsIgnoreCase(value)) {
                return method;
            }
        }
        throw new IllegalArgumentException("The company method [" + value + "] does not exists.");
    }

}
