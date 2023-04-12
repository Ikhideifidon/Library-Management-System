package com.github.ifidonIkhide.Library.Management.System.model.enumerate;

public enum Contact {
    MOBILE("Mobile Contact"),
    HOME("Home Contact"),
    WORK("Work Contact");

    private final String displayName;

    Contact(String displayName) { this.displayName = displayName; }

    public String getDisplayName() { return this.displayName; }


}
