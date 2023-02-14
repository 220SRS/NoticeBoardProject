package com.toyProject.NBPOrigin.ApiController;


import com.toyProject.NBPOrigin.dto.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @GetMapping
    public ResponseEntity postsList(){

        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/{post-id}")
    public ResponseEntity show(@PathVariable("post-id") int postid){



        return new ResponseEntity(HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity create(@RequestBody PostDto postDto){


        return new ResponseEntity(postDto, HttpStatus.CREATED);
    }



}
