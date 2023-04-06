package com.github.ifidonIkhide.Library.Management.System.model.enumerate;


public enum Title {
    LIBRARIAN("Librarian"),
    CIRCULATION_CLERK("Circulation Clerk"),
    REFERENCE_LIBRARIAN("Reference Librarian"),
    CATALOGUER("Cataloguer"),
    PAGE("Page");

    private final String displayName;

    Title(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
