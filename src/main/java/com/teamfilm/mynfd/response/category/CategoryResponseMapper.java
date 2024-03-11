package com.teamfilm.mynfd.response.category;

import com.teamfilm.mynfd.service.category.CategoryModel;

public class CategoryResponseMapper {

	private CategoryResponseMapper() {
		
	}
	
	public static CategoryPostResponse toPostResponse(CategoryModel model) {
		return CategoryPostResponse.builder()
				.message("User created")
				.categoryTitle(model.getCategoryTitle())
				.categoryDescription(model.getCategoryDescription())
				.build();
	}

	public static CategoryGetResponse toGetResponse(CategoryModel model) {
		return CategoryGetResponse.builder()
				.message("User found")
				.categoryTitle(model.getCategoryTitle())
				.categoryDescription(model.getCategoryDescription())
				.build();
	}
	
	public static CategoryPutResponse toPutResponse(CategoryModel model) {
		return CategoryPutResponse.builder()
				.message("User updated")
				.categoryTitle(model.getCategoryTitle())
				.categoryDescription(model.getCategoryDescription())
				.build();
	}
}
