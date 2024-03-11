package com.teamfilm.mynfd.service.post;

import com.teamfilm.mynfd.persistence.category.CategoryEntity;
import com.teamfilm.mynfd.service.category.CategoryModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PostModel {
    private String title;
    private String content;
    private Date addedDate;
    private CategoryModel category;
}
