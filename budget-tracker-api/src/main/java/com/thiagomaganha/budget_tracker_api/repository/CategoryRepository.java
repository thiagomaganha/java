package com.thiagomaganha.budget_tracker_api.repository;

import com.thiagomaganha.budget_tracker_api.repository.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
