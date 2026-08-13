package com.example.rest_api.controller;

import com.example.rest_api.dto.ApiResponse;
import com.example.rest_api.model.Post;
import com.example.rest_api.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ApiResponse<Post>> createPost(
            @Valid @RequestBody Post post) {

        Post createdPost = postService.createPost(post);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        "Post created successfully",
                        createdPost
                ));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<ApiResponse<List<Post>>> getAllPosts() {

        List<Post> posts = postService.getAllPosts();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Posts retrieved successfully",
                        posts
                )
        );
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Post>> getPostById(
            @PathVariable Long id) {

        Post post = postService.getPostById(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Post retrieved successfully",
                        post
                )
        );
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Post>> updatePost(
            @PathVariable Long id,
            @Valid @RequestBody Post post) {

        Post updatedPost = postService.updatePost(id, post);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Post updated successfully",
                        updatedPost
                )
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePost(
            @PathVariable Long id) {

        postService.deletePost(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Post deleted successfully",
                        null
                )
        );
    }
}