package com.teamfilm.nfd.response.category;

import com.teamfilm.nfd.response.Response;
import lombok.Builder;

@Builder
public record CategoryGetResponse(String message,
                                  String categoryTitle,
                                  String categoryDescription) implements Response {

}
