package com.github.ifidonIkhide.Library.Management.System.model.enumerate;

public enum RatingStatus {
    PENDING("Pending"),
    APPROVED("Approved"),
    REJECTED("Rejected");

    private final String displayName;

    RatingStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

