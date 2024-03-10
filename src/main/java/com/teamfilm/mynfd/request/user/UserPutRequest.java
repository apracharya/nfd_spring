package com.teamfilm.mynfd.request.user;

public record UserPutRequest(String firstName,
							 String lastName,
							 String username,
							 String password) {

}
