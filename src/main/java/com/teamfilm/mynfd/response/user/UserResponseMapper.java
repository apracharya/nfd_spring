package com.teamfilm.mynfd.response.user;

import com.teamfilm.mynfd.service.user.UserModel;

public class UserResponseMapper {

	private UserResponseMapper() {
		
	}
	
	public static UserPostResponse toPostResponse(UserModel user) {
		return UserPostResponse.builder()
				.message("User created")
				.firstName(user.firstName())
				.lastName(user.lastName())
				.username(user.username())
				.password(user.password())
				.build();
	}
	
	public static UserGetResponse toGetResponse(UserModel user) {
		return UserGetResponse.builder()
				.message("User found")
				.firstName(user.firstName())
				.lastName(user.lastName())
				.username(user.username())
				.password(user.password())
				.build();
	}
	
	public static UserPutResponse toPutResponse(UserModel user) {
		return UserPutResponse.builder()
				.message("User updated")
				.firstName(user.firstName())
				.lastName(user.lastName())
				.username(user.username())
				.password(user.password())
				.build();
	}
}
