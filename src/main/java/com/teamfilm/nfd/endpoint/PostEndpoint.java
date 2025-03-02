package com.teamfilm.nfd.endpoint;

import com.teamfilm.nfd.service.post.PostModel;
import com.teamfilm.nfd.service.post.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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
