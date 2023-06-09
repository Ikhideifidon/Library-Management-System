package com.github.ifidonIkhide.Library.Management.System.model.enumerate;

public enum Department {
    ADMIN("Administration"),
    HR("Human Resources"),
    IT("Information Technology"),
    FINANCE("Finance"),
    MARKETING("Marketing"),
    OPERATIONS("Operations");

    private final String displayName;

    Department(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
