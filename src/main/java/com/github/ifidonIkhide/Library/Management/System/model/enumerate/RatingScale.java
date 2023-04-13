package com.github.ifidonIkhide.Library.Management.System.model.enumerate;

public enum RatingScale {
    ONE_TO_FIVE("1-5", new Measure[] {
            Measure.ONE,
            Measure.TWO,
            Measure.THREE,
            Measure.FOUR,
            Measure.FIVE
    }),
    ONE_TO_TEN("1-10", new Measure[] {
            Measure.ONE,
            Measure.TWO,
            Measure.THREE,
            Measure.FOUR,
            Measure.FIVE,
            Measure.SIX,
            Measure.SEVEN,
            Measure.EIGHT,
            Measure.NINE,
            Measure.TEN
    }),

    UNSATISFACTORY_TO_EXCELLENT("Unsatisfactory-Excellent", new Measure[] {
            Measure.UNSATISFACTORY,
            Measure.BELOW_AVERAGE,
            Measure.SATISFACTORY,
            Measure.ABOVE_AVERAGE,
            Measure.EXCELLENT
    }),
    POOR_TO_OUTSTANDING("Poor-Outstanding", new Measure[] {
            Measure.POOR,
            Measure.BELOW_AVERAGE,
            Measure.AVERAGE,
            Measure.ABOVE_AVERAGE,
            Measure.OUTSTANDING
    });

    private final String displayName;
    private final Measure[] ratingValues;

    RatingScale(String displayName, Measure[] ratingValues) {
        this.displayName = displayName;
        this.ratingValues = ratingValues;
    }

    RatingScale(String displayName) {
        this(displayName, null);
    }

    public String getDisplayName() {
        return displayName;
    }

    public Measure[] getRatingValues() {
        return ratingValues;
    }

    public Measure getMeasureForValue(int value) {
        for (Measure measure : ratingValues) {
            if (measure.getValue() == value) {
                return measure;
            }
        }
        return null;
    }
}
