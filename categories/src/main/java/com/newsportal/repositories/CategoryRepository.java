package com.newsportal.repositories;

import com.newsportal.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sankalpa on 3/2/21
 */
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
