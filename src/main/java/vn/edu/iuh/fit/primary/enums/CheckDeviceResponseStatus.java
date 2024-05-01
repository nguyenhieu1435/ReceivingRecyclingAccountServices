package vn.edu.iuh.fit.primary.enums;

public enum CheckDeviceResponseStatus {
    REJECTED(0), WAITING(1), ACCEPTED(2);

    private int value;

    private CheckDeviceResponseStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CheckDeviceResponseStatus fromValue(int value) {
        for (CheckDeviceResponseStatus status : CheckDeviceResponseStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        return null;
    }
}
