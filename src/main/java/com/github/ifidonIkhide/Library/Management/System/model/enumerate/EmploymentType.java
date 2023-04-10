package com.github.ifidonIkhide.Library.Management.System.model.enumerate;

public enum EmploymentType {
    FULL_TIME("Full Time Staff"),
    PART_TIME("Part Time Staff"),
    INTERN("Intern Staff"),
    CONSULTANT("Consultant Staff"),
    CONTRACT("Contract Staff"),
    EXECUTIVE("Executive Staff");

    private final String displayName;

    EmploymentType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() { return this.displayName; }
}
