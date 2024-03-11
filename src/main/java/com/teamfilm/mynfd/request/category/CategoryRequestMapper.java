package com.teamfilm.mynfd.request.category;

import com.teamfilm.mynfd.service.category.CategoryModel;
import com.teamfilm.mynfd.service.user.UserModel;

public class CategoryRequestMapper {
	
	private CategoryRequestMapper() {
		
	}
	
	public static CategoryModel toModel(CategoryPostRequest request) {
		return CategoryModel.builder()
				.categoryTitle(request.categoryTitle())
				.categoryDescription(request.categoryDescription())
				.build();
	}
	
	public static CategoryModel toModel(CategoryPutRequest request) {
		return CategoryModel.builder()
				.categoryTitle(request.categoryTitle())
				.categoryDescription(request.categoryDescription())
				.build();
	}
	
}
