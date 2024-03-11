package com.teamfilm.mynfd.persistence.film;

import com.teamfilm.mynfd.persistence.category.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {
    List<FilmEntity> findByCategory(CategoryEntity category);
}
