package com.ipicicd.Controller;

import com.ipicicd.Dto.CreatePostRequest;
import com.ipicicd.Dto.PostResponse;
import com.ipicicd.Service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostRestController {

    private final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponse createPost(@Valid @RequestBody CreatePostRequest request) {
        return postService.createPost(request);
    }

    @GetMapping
    public List<PostResponse> findAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/{id}")
    public PostResponse findPostById(@PathVariable Long id) {
        return postService.findPostById(id);
    }
}
