package com.teamfilm.mynfd.endpoint;

import com.teamfilm.mynfd.service.post.PostModel;
import com.teamfilm.mynfd.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostEndpoint {

    private final PostService postService;

    public PostEndpoint(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create/category/{categoryId}")
    public ResponseEntity<PostModel> createPost(@RequestBody PostModel post, @PathVariable("categoryId") int categoryId) {
        PostModel model = postService.createPost(post, categoryId);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }


}
