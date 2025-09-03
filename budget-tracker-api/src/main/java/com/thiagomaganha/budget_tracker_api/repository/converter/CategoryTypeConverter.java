package com.thiagomaganha.budget_tracker_api.repository.converter;

import com.thiagomaganha.budget_tracker_api.repository.entity.CategoryType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoryTypeConverter implements AttributeConverter<CategoryType, String> {

    @Override
    public String convertToDatabaseColumn(CategoryType attribute) {
        return attribute != null ? attribute.name().toLowerCase() : null;
    }

    @Override
    public CategoryType convertToEntityAttribute(String dbData) {
        return dbData != null ? CategoryType.valueOf(dbData.toUpperCase()) : null;
    }
}