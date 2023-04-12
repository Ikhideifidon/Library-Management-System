package com.github.ifidonIkhide.Library.Management.System.model.enumerate;

public enum Criteria {
    JOB_KNOWLEDGE("Job Knowledge"),
    COMMUNICATION_SKILLS("Communication Skills"),
    INITIATIVE("Initiative"),
    ADAPTABILITY("Adaptability"),
    TEAMWORK("Teamwork"),
    TIME_MANAGEMENT("Time Management"),
    CUSTOMER_SERVICE("Customer Service"),
    LEADERSHIP("Leadership Skills"),
    PROBLEM_SOLVING("Problem Solving Skills"),
    DEPENDABILITY("Dependability");

    private final String displayName;

    Criteria(String displayName) { this.displayName = displayName; }

    public String getDisplayName() { return this.displayName; }
}
