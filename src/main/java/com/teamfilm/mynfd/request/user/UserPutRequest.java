package com.teamfilm.mynfd.request.user;

public record UserPutRequest(String username,
							 String firstName,
							 String lastName,
							 String password) {

}
