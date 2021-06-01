package com.lab9.SpringBoot.api;

import com.lab9.SpringBoot.domain.Post;
import com.lab9.SpringBoot.domain.PostDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;


@Service
public class PostApi {

    //private final Map<String, Post> posts;

    private final PostDataAdapter postDataAdapter;


    @Autowired
    public PostApi(PostDataAdapter postDataAdapter) {
        //this.posts = new HashMap<>();
        this.postDataAdapter = postDataAdapter;
    }

    public List<Post> getAllPosts() {
        //return new ArrayList<>(posts.values());
        return postDataAdapter.getAll();
    }

    public Post addPost(Post post) {
        //post.setId(UUID.randomUUID().toString());
        //posts.put(post.getId(), post);
        //return post;
        post.setPostedDate(LocalDateTime.now());
        post = postDataAdapter.save(post);
        return post;
    }

    public void deletePost(String id) {
        //posts.remove(post);
        postDataAdapter.delete(id);
    }

    public Post updatePost(Post post) {

        //posts.put(post.getId(), post);
        return postDataAdapter.update(post);
    }
}
