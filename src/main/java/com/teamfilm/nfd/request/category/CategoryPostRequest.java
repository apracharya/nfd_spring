package com.teamfilm.nfd.request.category;

import jakarta.validation.constraints.NotEmpty;

public record CategoryPostRequest(@NotEmpty String categoryTitle,
								  @NotEmpty String categoryDescription) {

}
