package com.newsportal.api.v1.model;

import lombok.Data;

import java.util.Date;

/**
 * @author sankalpa on 3/2/21
 */
@Data
public class CategoryDTO {
    private Long id;
    private String name;
    private String code;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private boolean active;
}
