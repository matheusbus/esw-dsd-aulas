package dsd.socket.protocol;

public enum CompanyMethod {

    GET,
    LIST,
    INSERT,
    UPDATE,
    DELETE,
    PAYROLL,
    RECEIVABLE;

    public static CompanyMethod fromString(String value) {
        for (CompanyMethod method : values()) {
            if (method.name().equalsIgnoreCase(value)) {
                return method;
            }
        }
        throw new IllegalArgumentException("The company method ["+value+"] does not exists.");
    }

}
