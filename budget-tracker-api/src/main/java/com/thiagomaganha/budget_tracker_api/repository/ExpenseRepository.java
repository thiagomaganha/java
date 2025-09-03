package com.thiagomaganha.budget_tracker_api.repository;

import com.thiagomaganha.budget_tracker_api.repository.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {
}
