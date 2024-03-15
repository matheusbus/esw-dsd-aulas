package dsd.socket.protocol;

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
