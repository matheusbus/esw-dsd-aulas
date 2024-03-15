package dsd.socket.protocol;

public enum Subject {

    PERSON,
    COMPANY,
    CUSTOMER,
    EMPLOYEE;

    public static Subject fromString(String value) {
        for (Subject subject : values()) {
            if (subject.name().equalsIgnoreCase(value)) {
                return subject;
            }
        }
        throw new IllegalArgumentException("The subject ["+value+"] does not exists.");
    }

}
