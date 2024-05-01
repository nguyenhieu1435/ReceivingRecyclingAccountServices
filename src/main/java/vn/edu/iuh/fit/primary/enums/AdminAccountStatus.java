package vn.edu.iuh.fit.primary.enums;

public enum AdminAccountStatus {
    ACTIVE(0), INACTIVE(1), DELETED(2);

    private int value;

    private AdminAccountStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AdminAccountStatus fromValue(int value) {
        for (AdminAccountStatus status : AdminAccountStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        return null;
    }
}
