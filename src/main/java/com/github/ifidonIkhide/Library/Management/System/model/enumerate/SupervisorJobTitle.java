package com.github.ifidonIkhide.Library.Management.System.model.enumerate;

public enum SupervisorJobTitle {
    CIRCULATION_SUPERVISOR("Circulation Supervisor"),
    REFERENCE_SUPERVISOR("Reference Supervisor"),
    COLLECTIONS_SUPERVISOR("Collections Supervisor");

    private final String displayName;

    SupervisorJobTitle(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

