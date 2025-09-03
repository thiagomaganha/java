package com.thiagomaganha.budget_tracker_api.repository;

import com.thiagomaganha.budget_tracker_api.repository.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
public class UserRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User createTestUser() {
        return new User(null, "testUser", "123456789", ZonedDateTime.now(), null);
    }

    @Test
    void shouldSaveUser_whenUserIsProvided() {
        // Given
        User testUser = createTestUser();
        // When
        User savedUser = userRepository.save(testUser);
        // Then
        assertNotNull(savedUser.getUserId());
        assertEquals("testUser", savedUser.getUsername());
    }

    @Test
    void shouldFindUserById_whenUserExists() {
        // Given
        User testUser = userRepository.save(createTestUser());
        // When
        Optional<User> foundUser = userRepository.findById(testUser.getUserId());
        // Then
        assertTrue(foundUser.isPresent());
        assertEquals(testUser.getUsername(), foundUser.get().getUsername());
    }

    @Test
    void shouldUpdateUser_whenUserIsSaved() {
        // Given
        User testUser = userRepository.save(createTestUser());
        testUser.setUsername("updatedUser");
        // When
        User updatedUser = userRepository.save(testUser);
        // Then
        assertEquals("updatedUser", updatedUser.getUsername());
        assertEquals(testUser.getUserId(), updatedUser.getUserId());
    }

    @Test
    void shouldDeleteUser_whenUserIsProvided() {
        // Given
        User testUser = userRepository.save(createTestUser());
        // When
        userRepository.deleteById(testUser.getUserId());
        // Then
        Optional<User> deletedUser = userRepository.findById(testUser.getUserId());
        assertFalse(deletedUser.isPresent());
    }
}
