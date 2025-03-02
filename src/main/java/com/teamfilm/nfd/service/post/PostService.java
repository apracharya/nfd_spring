package com.teamfilm.nfd.service.post;

public interface PostService {
    PostModel createPost(PostModel post, int categoryId);
    PostModel readPost(int postId);
}
