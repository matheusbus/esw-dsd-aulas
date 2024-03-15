package dsd.socket.protocol;

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
