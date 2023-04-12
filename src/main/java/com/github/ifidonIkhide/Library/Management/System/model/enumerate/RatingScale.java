package com.github.ifidonIkhide.Library.Management.System.model.enumerate;

public enum RatingScale {
    ONE_TO_FIVE("1-5", new NonNumericBasedRating[] {
            NonNumericBasedRating.ONE,
            NonNumericBasedRating.TWO,
            NonNumericBasedRating.THREE,
            NonNumericBasedRating.FOUR,
            NonNumericBasedRating.FIVE
    }),
    ONE_TO_TEN("1-10", new NonNumericBasedRating[] {
            NonNumericBasedRating.ONE,
            NonNumericBasedRating.TWO,
            NonNumericBasedRating.THREE,
            NonNumericBasedRating.FOUR,
            NonNumericBasedRating.FIVE,
            NonNumericBasedRating.SIX,
            NonNumericBasedRating.SEVEN,
            NonNumericBasedRating.EIGHT,
            NonNumericBasedRating.NINE,
            NonNumericBasedRating.TEN
    }),

    UNSATISFACTORY_TO_EXCELLENT("Unsatisfactory-Excellent", new NonNumericBasedRating[] {
            NonNumericBasedRating.UNSATISFACTORY,
            NonNumericBasedRating.BELOW_AVERAGE,
            NonNumericBasedRating.SATISFACTORY,
            NonNumericBasedRating.ABOVE_AVERAGE,
            NonNumericBasedRating.EXCELLENT
    }),
    POOR_TO_OUTSTANDING("Poor-Outstanding", new NonNumericBasedRating[] {
            NonNumericBasedRating.POOR,
            NonNumericBasedRating.BELOW_AVERAGE,
            NonNumericBasedRating.AVERAGE,
            NonNumericBasedRating.ABOVE_AVERAGE,
            NonNumericBasedRating.OUTSTANDING
    });

    private final String displayName;
    private final NonNumericBasedRating[] ratingValues;

    RatingScale(String displayName, NonNumericBasedRating[] ratingValues) {
        this.displayName = displayName;
        this.ratingValues = ratingValues;
    }

    RatingScale(String displayName) {
        this(displayName, null);
    }

    public String getDisplayName() {
        return displayName;
    }

    public NonNumericBasedRating[] getRatingValues() {
        return ratingValues;
    }
}
