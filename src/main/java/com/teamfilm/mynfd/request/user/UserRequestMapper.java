package com.teamfilm.mynfd.request.user;

import com.teamfilm.mynfd.service.user.UserModel;

public class UserRequestMapper {
	
	private UserRequestMapper() {
		
	}
	
	public static UserModel toModel(UserPostRequest request) {
		return UserModel.builder()
				.firstName(request.firstName())
				.lastName(request.lastName())
				.username(request.username())
				.password(request.password())
				.build();
	}
	
	public static UserModel toModel(UserPutRequest request) {
		return UserModel.builder()
				.firstName(request.firstName())
				.lastName(request.lastName())
				.username(request.username())
				.password(request.password())
				.build();
	}
	
}
