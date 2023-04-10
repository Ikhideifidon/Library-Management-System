package com.github.ifidonIkhide.Library.Management.System.model.enumerate;

public enum CoverageType {
    LOW("Lowest Coverage"),
    MEDIUM("More inclusive than the least"),
    HIGH("High coverage with special benefits"),
    ALL("Premium coverage with customizable benefits");

    private final String displayName;

    CoverageType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() { return this.displayName; }
}
