package com.toyProject.NBPOrigin.Repository;

import com.toyProject.NBPOrigin.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    Post save(Post post);
    Optional<Post> findById(int id);
    Optional<Post> findByTitle(String title);
    List<Post> findAll();
    Post update(int postId, Post post);
    void delete(int postId);


}
