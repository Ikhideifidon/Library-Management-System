package com.github.ifidonIkhide.Library.Management.System.model.enumerate;

public enum ManagerJobTitle {
    DIRECTOR("Director"),
    ASSISTANT_DIRECTOR("Assistant Director"),
    FINANCE_MANAGER("Finance Manager"),
    HUMAN_RESOURCES_MANAGER("Human Resources Manager");

    private final String displayName;

    ManagerJobTitle(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}