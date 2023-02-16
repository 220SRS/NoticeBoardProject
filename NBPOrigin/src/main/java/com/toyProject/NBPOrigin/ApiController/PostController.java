package com.toyProject.NBPOrigin.ApiController;

import com.toyProject.NBPOrigin.dto.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/posts")
public class PostController {


    @GetMapping
    public ResponseEntity postList(){


        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{post-id}")
    public ResponseEntity show(@PathVariable("post-id") int postId){

        return new ResponseEntity(HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity create(@RequestBody PostDto postDto){

        return new ResponseEntity(HttpStatus.CREATED);
    }




    @PatchMapping("/{post-id}")
    public ResponseEntity update(@PathVariable("post-id") int postId,
                                 @RequestBody PostDto postDto){

        return new ResponseEntity(HttpStatus.OK);
    }


    @DeleteMapping("/{post-id}")
    public ResponseEntity delete(@PathVariable("post-id") int postID){
        return new ResponseEntity(HttpStatus.OK);
    }
}