package com.thiagomaganha.budget_tracker_api.repository.entity;

import com.thiagomaganha.budget_tracker_api.repository.converter.CategoryTypeConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.UUID;
import java.time.ZonedDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "category_id", columnDefinition = "UUID")
    private UUID categoryId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "category_type", nullable = false)
    @Convert(converter = CategoryTypeConverter.class)
    private CategoryType CategoryType;

    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;
}

