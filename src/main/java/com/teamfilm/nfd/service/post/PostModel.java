package com.teamfilm.nfd.service.post;

import com.teamfilm.nfd.service.category.CategoryModel;
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
