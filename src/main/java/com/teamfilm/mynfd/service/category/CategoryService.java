package com.teamfilm.mynfd.service.category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    CategoryModel createCategory(CategoryModel category);
    CategoryModel updateCategory(CategoryModel category, int categoryId);
    Optional<CategoryModel> readCategory(int categoryId);
    List<CategoryModel> readAllCategories();
    void deleteCategory(int categoryId);


}
