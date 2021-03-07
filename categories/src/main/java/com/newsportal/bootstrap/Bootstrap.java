package com.newsportal.bootstrap;

import com.newsportal.domain.Category;
import com.newsportal.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @author sankalpa on 3/2/21
 */
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private static Logger LOGGER = Logger.getLogger(Bootstrap.class.getName());

    public Bootstrap(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
    }

    private void loadCategories() {
        Category business = new Category();
        business.setName("Business");
        business.setCode("BUSI");

        Category technology = new Category();
        technology.setName("Technology");
        technology.setCode("TECH");

        categoryRepository.save(business);
        categoryRepository.save(technology);
        LOGGER.info("THE CATEGORY IS LOADED ::: "+categoryRepository.count());
    }
}
