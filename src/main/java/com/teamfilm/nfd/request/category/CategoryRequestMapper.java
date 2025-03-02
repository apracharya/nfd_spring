package com.teamfilm.nfd.request.category;

import com.teamfilm.nfd.service.category.CategoryModel;

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
