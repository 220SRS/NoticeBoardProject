package com.toyProject.NBPOrigin.service;

import com.toyProject.NBPOrigin.model.Post;
import com.toyProject.NBPOrigin.Repository.JdbcTemplatePostRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final JdbcTemplatePostRepository jdbcTemplatePostRepository;


    public PostService(JdbcTemplatePostRepository jdbcTemplatePostRepository){
        this.jdbcTemplatePostRepository = jdbcTemplatePostRepository;
    }

    public List<Post> list(){

        List<Post> response = jdbcTemplatePostRepository.findAll();

        return response;
    }


    public Post show(int postId){

        Optional<Post> response = jdbcTemplatePostRepository.findById(postId);

        return response.orElse(null);
    }


    public Post create(Post post){

        return jdbcTemplatePostRepository.save(post);
    }


    public Post update(int postId, Post post){


        return jdbcTemplatePostRepository.update(postId, post);
    }


    public void delete(int postID) {
        jdbcTemplatePostRepository.delete(postID);
    }
}
