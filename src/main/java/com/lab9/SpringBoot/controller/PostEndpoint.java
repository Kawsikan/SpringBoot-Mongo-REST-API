package com.lab9.SpringBoot.controller;

import com.lab9.SpringBoot.api.PostApi;
import com.lab9.SpringBoot.domain.Post;
import com.lab9.SpringBoot.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostEndpoint {

    private final PostApi postApi;

    @Autowired
    public PostEndpoint(PostApi postApi) {
        this.postApi = postApi;
    }

    @GetMapping
    public List<Post> getPosts() {
        return postApi.getAllPosts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post addPost(@RequestBody PostDto postDto) {

        Post post = new Post();
        post.setName(postDto.getName());
        post.setDescription(postDto.getDescription());
        return postApi.addPost(post);
    }

    @DeleteMapping(path = "{id}")
    public void deletePost(@PathVariable("id") String id) {
        postApi.deletePost(id);
    }
    //"/:id"
    @PutMapping(path = "{id}")
    public Post updatePost(@PathVariable("id") String id, @RequestBody PostDto postDto) {

        Post post = new Post();
        post.setId(id);
        post.setName(postDto.getName());
        post.setDescription(postDto.getDescription());
        return postApi.updatePost(post);

    }
    // Sir used another method check it
}
