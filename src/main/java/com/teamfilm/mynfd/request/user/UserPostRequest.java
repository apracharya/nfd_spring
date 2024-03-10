package com.teamfilm.mynfd.request.user;

public record UserPostRequest(String firstName,
							  String lastName,
							  String username,
							  String password) {

}
