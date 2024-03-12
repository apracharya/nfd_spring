package com.teamfilm.mynfd.persistence.film;

import com.teamfilm.mynfd.persistence.category.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {



    List<FilmEntity> findByCategory(CategoryEntity category);

    /**
     *
     * The issue that could be encountered while searching, if the keyword is not present then there could
     * be an InvalidDataAccessApiUsageException which is probably caused by Hibernate version
     * if issues arise in the method below, you can use this query and method
     * implementation which solves the issue
     * <p> @Query("select p from FilmEntity f where p.title like :key) </p>
     * List<FilmEntity> searchByTitle(@Param("hey") String title);
     *
     * <p> after this, in implementation, same impl but in method call, </p>
     * filmRepository.searchByTitle("%"+keyword+"%");
     * this will do!
     */

    List<FilmEntity> findByTitleContaining(String title);


}
