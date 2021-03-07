package com.newsportal.services;

import com.newsportal.api.v1.mapper.CategoryMapper;
import com.newsportal.api.v1.model.CategoryDTO;
import com.newsportal.domain.Category;
import com.newsportal.repositories.CategoryRepository;
import com.newsportal.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sankalpa on 3/7/21
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository,CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::categoryToCategoryDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream().map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO createNewCategory(CategoryDTO categoryDTO) {
        Category category = this.categoryRepository.save(categoryMapper.categoryDTOToCategory(categoryDTO));
        return categoryMapper.categoryToCategoryDTO(category);
    }

    @Override
    public CategoryDTO patchCategory(Long id, CategoryDTO categoryDTO) {
        return this.categoryRepository.findById(id)
                .map(category->{
                    category.setName(categoryDTO.getName());
                    category.setDescription(categoryDTO.getDescription());
                    Category patchedCategory = categoryRepository.save(category);
                    return categoryMapper.categoryToCategoryDTO(patchedCategory);
                    // todo : have proper error messages.
                }).orElseThrow(ResourceNotFoundException::new);
    }
}
