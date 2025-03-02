package com.teamfilm.nfd.service.category;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    void readCategory(){
        CategoryModel expectedModel = CategoryModel.builder()
                .categoryTitle("Comedy")
                .categoryDescription("Comedy movies")
                .build();

        CategoryModel fetched = categoryService.readCategory(4).orElseThrow();

        Assertions.assertEquals(expectedModel.getCategoryTitle(), fetched.getCategoryTitle());
        Assertions.assertEquals(expectedModel.getCategoryDescription(), fetched.getCategoryDescription());
    }

    @Test
    void createCategory(){
        CategoryModel expectedModel = CategoryModel.builder()
                .categoryTitle("Fiction")
                .categoryDescription("Fiction Films")
                .build();

        CategoryModel created = categoryService.createCategory(expectedModel);


        Assertions.assertNotNull(created.getCategoryId());

        // individual properties
        Assertions.assertEquals(expectedModel.getCategoryTitle(), created.getCategoryTitle());
        Assertions.assertEquals(expectedModel.getCategoryDescription(), created.getCategoryDescription());

        CategoryModel fetched = categoryService.readCategory(created.getCategoryId()).orElseThrow();
        Assertions.assertEquals(created, fetched);

    }
}
