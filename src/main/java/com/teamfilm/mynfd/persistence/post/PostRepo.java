package com.teamfilm.mynfd.persistence.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepo extends JpaRepository<PostEntity, Integer> {

//    List<PostEntity> findAllByCategory();
}
