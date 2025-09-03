package com.thiagomaganha.budget_tracker_api.repository;

import com.thiagomaganha.budget_tracker_api.repository.entity.Category;
import com.thiagomaganha.budget_tracker_api.repository.entity.CategoryType;
import com.thiagomaganha.budget_tracker_api.repository.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
public class CategoryRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    private User testUser;

    @BeforeEach
    void setUp() {

    }

    private Category createTestCategory() {
        return new Category(null, "Groceries", CategoryType.EXPENSE, ZonedDateTime.now());
    }

    @Test
    void shouldSaveCategory_whenCategoryIsProvided() {
        // Given
        Category testCategory = createTestCategory();
        // When
        Category savedCategory = categoryRepository.save(testCategory);
        // Then
        assertNotNull(savedCategory.getCategoryId());
        assertEquals("Groceries", savedCategory.getCategoryName());
    }

    @Test
    void shouldFindCategoryById_whenCategoryExists() {
        // Given
        Category testCategory = categoryRepository.save(createTestCategory());
        // When
        Optional<Category> foundCategory = categoryRepository.findById(testCategory.getCategoryId());
        // Then
        assertTrue(foundCategory.isPresent());
        assertEquals(testCategory.getCategoryName(), foundCategory.get().getCategoryName());
    }

    @Test
    void shouldUpdateCategory_whenCategoryIsSaved() {
        // Given
        Category testCategory = categoryRepository.save(createTestCategory());
        testCategory.setCategoryName("Utilities");
        // When
        Category updatedCategory = categoryRepository.save(testCategory);
        // Then
        assertEquals("Utilities", updatedCategory.getCategoryName());
    }

    @Test
    void shouldDeleteCategory_whenCategoryIsProvided() {
        // Given
        Category testCategory = categoryRepository.save(createTestCategory());
        // When
        categoryRepository.deleteById(testCategory.getCategoryId());
        // Then
        Optional<Category> deletedCategory = categoryRepository.findById(testCategory.getCategoryId());
        assertFalse(deletedCategory.isPresent());
    }
}
