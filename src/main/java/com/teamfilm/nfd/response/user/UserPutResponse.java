package com.teamfilm.nfd.response.user;

import com.teamfilm.nfd.response.Response;
import lombok.Builder;

@Builder
public record UserPutResponse(String message,
							  String username,
							  String firstName,
							  String lastName,
							  String password) implements Response {

}
