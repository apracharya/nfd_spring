package com.teamfilm.mynfd.service.category;

import com.teamfilm.mynfd.persistence.category.CategoryEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {

    private int categoryId;

    @NotEmpty
    private String categoryTitle;

    @NotEmpty
    private String categoryDescription;

//    public int getCategoryId() {
//        return categoryId;
//    }
//
//    public String getCategoryTitle() {
//        return categoryTitle;
//    }
//
//    public String getCategoryDescription() {
//        return categoryDescription;
//    }

    public static CategoryModel fromEntity(CategoryEntity entity){
        return CategoryModel.builder()
                .categoryId(entity.getCategoryId())
                .categoryTitle(entity.getCategoryTitle())
                .categoryDescription(entity.getCategoryDescription())
                .build();
    }

    public CategoryEntity toEntity(){
        return CategoryEntity.builder()
                .categoryId(categoryId)
                .categoryTitle(categoryTitle)
                .categoryDescription(categoryDescription)
                .build();
    }
}
