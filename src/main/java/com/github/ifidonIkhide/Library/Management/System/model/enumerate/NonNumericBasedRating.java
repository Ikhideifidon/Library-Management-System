package com.github.ifidonIkhide.Library.Management.System.model.enumerate;

public enum NonNumericBasedRating {
    ONE("One", 1),
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    UNSATISFACTORY("Unsatisfactory", 1),
    BELOW_AVERAGE("Below Average", 2),
    SATISFACTORY("Satisfactory", 3),
    ABOVE_AVERAGE("Above Average", 4),
    EXCELLENT("Excellent", 5),
    POOR("Poor", 1),
    AVERAGE("Average", 3),
    OUTSTANDING("Outstanding", 5);


    private final String displayName;
    private final int value;

    NonNumericBasedRating(String displayName, int value) {
        this.displayName = displayName;
        this.value = value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getValue() {
        return value;
    }
}
