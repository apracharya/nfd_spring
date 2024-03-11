package com.teamfilm.mynfd.response.category;

import com.teamfilm.mynfd.response.Response;
import lombok.Builder;

@Builder
public record CategoryGetResponse(String message,
                                  String categoryTitle,
                                  String categoryDescription) implements Response {

}
