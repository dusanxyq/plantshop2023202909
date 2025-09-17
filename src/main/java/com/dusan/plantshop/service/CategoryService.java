package com.dusan.plantshop.service;

import com.dusan.plantshop.model.Category;
import com.dusan.plantshop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category updated) {
        return categoryRepository.findById(id)
                .map(existing -> {
                    existing.setName(updated.getName());
                    return categoryRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Kategorija nije pronađena"));
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
