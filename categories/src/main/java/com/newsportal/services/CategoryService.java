package com.newsportal.services;


import com.newsportal.api.v1.model.CategoryDTO;

import java.util.List;

/**
 * @author sankalpa on 3/7/21
 */
public interface CategoryService {
    CategoryDTO getCategoryById(Long id);
    List<CategoryDTO> getAllCategories();
    CategoryDTO createNewCategory(CategoryDTO categoryDTO);
    CategoryDTO patchCategory(Long id,CategoryDTO categoryDTO);
}
