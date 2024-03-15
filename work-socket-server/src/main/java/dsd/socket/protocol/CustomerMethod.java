package dsd.socket.protocol;

public enum CustomerMethod {

    GET,
    LIST,
    INSERT,
    UPDATE,
    DELETE,
    BUY;

    public static CustomerMethod fromString(String value) {
        for (CustomerMethod method : values()) {
            if (method.name().equalsIgnoreCase(value)) {
                return method;
            }
        }
        throw new IllegalArgumentException("The method ["+value+"] does not exists.");
    }

}
