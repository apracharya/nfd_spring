package com.teamfilm.mynfd.service.post;

import com.teamfilm.mynfd.exception.NotFoundException;
import com.teamfilm.mynfd.persistence.category.CategoryEntity;
import com.teamfilm.mynfd.persistence.category.CategoryRepository;
import com.teamfilm.mynfd.persistence.post.PostEntity;
import com.teamfilm.mynfd.persistence.post.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PostServiceImplementation implements PostService{

    private PostRepo postRepo;

    private ModelMapper modelMapper;

    private CategoryRepository categoryRepo;

    public PostServiceImplementation(PostRepo postRepo, ModelMapper modelMapper, CategoryRepository categoryRepo) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public PostModel createPost(PostModel post, int categoryId) {

        CategoryEntity cat = categoryRepo.findById(categoryId).orElseThrow(NotFoundException::new);

        PostEntity entity = modelMapper.map(post, PostEntity.class);
        entity.setImageName("default.png");
        entity.setAddedDate(new Date());
        entity.setCategory(cat);

        PostEntity created = postRepo.save(entity);

        return modelMapper.map(created, PostModel.class);
    }

    @Override
    public PostModel readPost(int postId) {
        return null;
    }
}
