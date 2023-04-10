package com.github.ifidonIkhide.Library.Management.System.model.enumerate;

public enum SalaryType {
    BASE("Base"),
    OVERTIME("Overtime"),
    COMMISSION("commissions"),
    BONUSES("Bonuses");

    private final String displayName;

    SalaryType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() { return this.displayName; }
}
