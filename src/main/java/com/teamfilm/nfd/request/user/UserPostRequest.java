package com.teamfilm.nfd.request.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserPostRequest(@Size(min=5, max = 25, message = "length of username must be between 5 and 25")
							  String username,
							  String firstName,
							  String lastName,
							  @NotEmpty(message = "password must not be empty")
							  String password) {
	// password null validation is done by BCryptEncoder

}
