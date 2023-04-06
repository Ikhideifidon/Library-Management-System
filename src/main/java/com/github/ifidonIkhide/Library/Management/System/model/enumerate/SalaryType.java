package com.github.ifidonIkhide.Library.Management.System.model.enumerate;

public enum SalaryType {
    HOURLY("Hourly"),
    DAILY("Daily"),
    WEEKLY("Weekly"),
    MONTHLY("Monthly");

    private String displayName;

    SalaryType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
