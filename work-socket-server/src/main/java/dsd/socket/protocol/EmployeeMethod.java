package dsd.socket.protocol;

public enum EmployeeMethod {

    GET,
    LIST,
    INSERT,
    UPDATE,
    DELETE;

    public static EmployeeMethod fromString(String value) {
        for (EmployeeMethod method : values()) {
            if (method.name().equalsIgnoreCase(value)) {
                return method;
            }
        }
        throw new IllegalArgumentException("The Employee Method ["+value+"] does not exists.");
    }

}
