package com.newsportal.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author sankalpa on 3/2/21
 */
@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "The name is required")
    private String name;
    @NotNull(message = "The code is required")
    @Size(min=3,max=6,message = "The code must be between {min} and {max} characters.")
    private String code;
    @Size(max = 100,message = "The description must be less than or {max} characters.")
    private String description;
    @Column(name = "created_at")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date createdAt;
    @Column(name = "updated_at")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updatedAt;
    private boolean active;

    @PrePersist
    protected void onCreate(){this.createdAt = new Date();}

    @PreUpdate
    protected void onUpdate(){this.updatedAt = new Date();}
}
