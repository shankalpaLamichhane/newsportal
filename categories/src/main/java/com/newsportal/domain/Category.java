package com.newsportal.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author sankalpa on 3/2/21
 */
@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "The name is required")
    private String name;
    @NotNull(message = "The code is required")
    @Size(min=3,max=6,message = "The code must be between {min} and {max} characters.")
    private String code;
    @Size(max = 100,message = "The description must be less than or {max} characters.")
    private String description;
}
