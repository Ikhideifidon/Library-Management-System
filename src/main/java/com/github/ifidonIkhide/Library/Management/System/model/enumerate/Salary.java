package com.github.ifidonIkhide.Library.Management.System.model.enumerate;

public enum Salary {
    HOURLY("Hourly"),
    DAILY("Daily"),
    WEEKLY("Weekly"),
    MONTHLY("Monthly");

    private String displayName;

    Salary(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
