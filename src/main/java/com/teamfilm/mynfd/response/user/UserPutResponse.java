package com.teamfilm.mynfd.response.user;

import com.teamfilm.mynfd.response.Response;
import lombok.Builder;

@Builder
public record UserPutResponse(String message,
							  int id,
							  String firstName,
							  String lastName,
							  String username,
							  String password) implements Response {

}
