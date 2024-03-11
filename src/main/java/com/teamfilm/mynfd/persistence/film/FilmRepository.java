package com.teamfilm.mynfd.persistence.film;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {
//    List<FilmEntity> findByCategory(CategoryEntity category);
}
