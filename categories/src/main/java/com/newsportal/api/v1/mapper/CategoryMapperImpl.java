package com.newsportal.api.v1.mapper;

import com.newsportal.api.v1.model.CategoryDTO;
import com.newsportal.domain.Category;
import org.springframework.stereotype.Service;

/**
 * @author sankalpa on 3/7/21
 */
@Service
public class CategoryMapperImpl implements CategoryMapper{

    @Override
    public CategoryDTO categoryToCategoryDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setCode(category.getCode());
        dto.setDescription(category.getDescription());
        dto.setName(category.getName());
        dto.setId(category.getId());
        dto.setCreatedAt(category.getCreatedAt());
        dto.setUpdatedAt(category.getUpdatedAt());
        dto.setActive(category.isActive());
        return dto;
    }

    @Override
    public Category categoryDTOToCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCode(categoryDTO.getCode());
        category.setDescription(categoryDTO.getDescription());
        category.setName(categoryDTO.getName());
        category.setId(categoryDTO.getId());
        category.setCreatedAt(categoryDTO.getCreatedAt());
        category.setUpdatedAt(categoryDTO.getUpdatedAt());
        category.setActive(categoryDTO.isActive());
        return category;
    }
}
