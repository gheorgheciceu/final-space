package com.sa.enums;

import java.text.MessageFormat;

public enum PlanetStatus {
    OK("ok"),
    NOT_OK("!ok"),
    TODO("todo"),
    EN_ROUTE("en route");

    private String status;

    private PlanetStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static PlanetStatus getStatus(String value) {
        for (PlanetStatus status : PlanetStatus.values()) {
            if (status.getStatus().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new RuntimeException(MessageFormat.format("Status {0} does not exist", value));
    }
}
