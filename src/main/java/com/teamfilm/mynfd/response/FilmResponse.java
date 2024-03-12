package com.teamfilm.mynfd.response;

import com.teamfilm.mynfd.service.film.FilmModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class FilmResponse {

    private List<FilmModel> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean lastPage;
}
