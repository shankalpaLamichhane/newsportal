package com.newsportal.controllers.v1;

import com.newsportal.ResponseWrapper;
import com.newsportal.api.v1.model.CategoryDTO;
import com.newsportal.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 * @author sankalpa on 3/7/21
 */
@RestController
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public static final String BASE_URL = "/api/v1/categories";

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper getCategory(@PathVariable Long id){
        return ResponseWrapper.getSuccessResponse(this.categoryService.getCategoryById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseWrapper createNewCategory(@RequestBody CategoryDTO categoryDTO){
        return ResponseWrapper.getSuccessResponse(this.categoryService.createNewCategory(categoryDTO));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper getAllCategories(){
        return ResponseWrapper.getSuccessResponse(this.categoryService.getAllCategories());
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper patchCategory(@PathVariable Long id,@RequestBody CategoryDTO categoryDTO){
        return ResponseWrapper.getSuccessResponse(this.categoryService.patchCategory(id,categoryDTO));
    }
}
