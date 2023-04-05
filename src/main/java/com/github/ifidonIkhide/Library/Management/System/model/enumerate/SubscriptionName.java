package com.github.ifidonIkhide.Library.Management.System.model.enumerate;

public enum SubscriptionName {
    BASIC("Basic"),
    PREMIUM("Premium"),
    GOLD("Gold");

    private final String displayName;

    SubscriptionName(String displayName) {
        this.displayName = displayName;
    }


    // .................................................UX.......................................
    public String getDisplayName() {
        return displayName;
    }
}