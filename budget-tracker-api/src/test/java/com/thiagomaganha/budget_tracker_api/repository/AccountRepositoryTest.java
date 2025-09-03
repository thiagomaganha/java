package com.thiagomaganha.budget_tracker_api.repository;

import com.thiagomaganha.budget_tracker_api.repository.entity.Account;
import com.thiagomaganha.budget_tracker_api.repository.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
public class AccountRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = userRepository.save(new User(null, "testUser", "123456789", ZonedDateTime.now(), null, null));
    }

    private Account createTestAccount() {
        return new Account(null, ZonedDateTime.now(), "ACT123466", testUser, null, null);
    }

    @Test
    void shouldSaveAccount_whenAccountIsProvided() {
        // Given
        Account testAccount = createTestAccount();
        // When
        Account savedAccount = accountRepository.save(testAccount);
        // Then
        assertNotNull(savedAccount.getAccountId());
        assertEquals("ACT123466", savedAccount.getAccountName());
    }

    @Test
    void shouldFindAccountById_whenAccountExists() {
        // Given
        Account testAccount = accountRepository.save(createTestAccount());
        // When
        Optional<Account> foundAccount = accountRepository.findById(testAccount.getAccountId());
        // Then
        assertTrue(foundAccount.isPresent());
        assertEquals(testAccount.getAccountId(), foundAccount.get().getAccountId());
    }

    @Test
    void shouldFindAllAccounts_whenMultipleAccountsExist() {
        // Given
        accountRepository.save(createTestAccount());
        accountRepository.save(new Account(null,ZonedDateTime.now(), "Savings",  testUser,null, null));
        // When
        List<Account> accounts = accountRepository.findAll();
        // Then
        assertEquals(2, accounts.size());
    }

    @Test
    void shouldUpdateAccount_whenAccountIsSaved() {
        // Given
        Account testAccount = accountRepository.save(createTestAccount());
        testAccount.setAccountName("Savings");
        // When
        Account updatedAccount = accountRepository.save(testAccount);
        // Then
        assertEquals("Savings", updatedAccount.getAccountName());
    }

    @Test
    void shouldDeleteAccount_whenAccountIsProvided() {
        // Given
        Account testAccount = accountRepository.save(createTestAccount());
        // When
        accountRepository.deleteById(testAccount.getAccountId());
        // Then
        Optional<Account> deletedAccount = accountRepository.findById(testAccount.getAccountId());
        assertFalse(deletedAccount.isPresent());
    }

    @Test
    void shouldFindByUserUserId_whenAccountsExistForUser() {
        // Given
        accountRepository.save(createTestAccount());
        // When
        Optional<Account> foundAccount = accountRepository.findByUser_UserId(testUser.getUserId());
        // Then
        assertThat(foundAccount).isPresent();
        assertThat(foundAccount.get().getUser().getUserId()).isEqualTo(testUser.getUserId());
    }
}
