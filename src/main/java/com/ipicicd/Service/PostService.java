package com.ipicicd.Service;

import com.ipicicd.Dto.CreatePostRequest;
import com.ipicicd.Dto.PostResponse;
import com.ipicicd.Entity.Post;
import com.ipicicd.Entity.User;
import com.ipicicd.Repository.PostRepository;
import com.ipicicd.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public PostResponse createPost(CreatePostRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Post post = new Post();
        post.setTitle(request.title());
        post.setContent(request.content());
        post.setUser(user);

        Post saved = postRepository.save(post);
        return toResponse(saved);
    }

    public List<PostResponse> findAllPosts() {
        return postRepository.findAll().stream().map(this::toResponse).toList();
    }

    public PostResponse findPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));
        return toResponse(post);
    }

    public List<PostResponse> findPostsByUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return postRepository.findAllByUserId(userId).stream().map(this::toResponse).toList();
    }

    private PostResponse toResponse(Post post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getUser().getId(),
                post.getUser().getUsername(),
                post.getTimestamp()
        );
    }
}

