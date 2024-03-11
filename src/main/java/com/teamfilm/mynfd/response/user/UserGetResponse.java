package com.teamfilm.mynfd.response.user;

import com.teamfilm.mynfd.response.Response;
import lombok.Builder;

@Builder
public record UserGetResponse(String message,
							  String username,
							  String firstName,
							  String lastName,
							  String password) implements Response {

}
