package dsd.socket.protocol;

public enum EmployeeMethod {

    GET,
    LIST,
    INSERT,
    UPDATE,
    DELETE,
    RESIGN;

    public static EmployeeMethod fromString(String value) {
        for (EmployeeMethod method : values()) {
            if (method.name().equalsIgnoreCase(value)) {
                return method;
            }
        }
        throw new IllegalArgumentException("The method ["+value+"] does not exists.");
    }

}
