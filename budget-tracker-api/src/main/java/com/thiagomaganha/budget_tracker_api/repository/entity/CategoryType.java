package com.thiagomaganha.budget_tracker_api.repository.entity;

public enum CategoryType {
    INCOME,
    EXPENSE;

    public static CategoryType fromString(String value) {
        return value != null ? CategoryType.valueOf(value.toUpperCase()) : null;
    }

    public String toStringValue() {
        return this.name().toLowerCase();
    }
}

