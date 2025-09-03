package com.thiagomaganha.budget_tracker_api.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Set;
import java.util.UUID;
import java.time.ZonedDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "account_id", columnDefinition = "UUID")
    private UUID accountId;

    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;

    // An account belongs to one user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // An account can have many incomes
    @OneToMany(mappedBy = "account")
    private Set<Income> incomes;

    // An account can have many fixed expenses
    @OneToMany(mappedBy = "account")
    private Set<Expense> fixedExpenses;
}
