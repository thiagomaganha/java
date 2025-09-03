package com.thiagomaganha.budget_tracker_api.repository;

import com.thiagomaganha.budget_tracker_api.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
