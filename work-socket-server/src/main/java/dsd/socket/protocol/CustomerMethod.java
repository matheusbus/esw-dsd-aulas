package dsd.socket.protocol;

public enum CustomerMethod {

    GET,
    LIST,
    INSERT,
    UPDATE,
    DELETE,
    PAY;

    public static CustomerMethod fromString(String value) {
        for (CustomerMethod method : values()) {
            if (method.name().equalsIgnoreCase(value)) {
                return method;
            }
        }
        throw new IllegalArgumentException("The Customer Method ["+value+"] does not exists.");
    }

}
