package com.example.rest_api.service;

import com.example.rest_api.model.Post;
import com.example.rest_api.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Create
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    // Read all
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Read one
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Post not found with id: " + id));
    }

    // Update
    public Post updatePost(Long id, Post updatedPost) {

        Post existingPost = getPostById(id);

        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());

        return postRepository.save(existingPost);
    }

    // Delete
    public void deletePost(Long id) {

        Post existingPost = getPostById(id);

        postRepository.delete(existingPost);
    }
}