package com.toyProject.NBPOrigin.ApiController;

import com.toyProject.NBPOrigin.dto.PostDto;
import com.toyProject.NBPOrigin.mapper.PostMapper;
import com.toyProject.NBPOrigin.model.Post;
import com.toyProject.NBPOrigin.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;

    public PostController(PostService postService, PostMapper postMapper) {
        this.postService = postService;
        this.postMapper = postMapper;
    }

    @GetMapping
    public ResponseEntity postList(){
        List<Post> posts = postService.list();
        List<PostDto> postDtoList = posts.stream()
                .map(post -> postMapper.postTopostDto(post))
                .collect(Collectors.toList());
        return new ResponseEntity(postDtoList,HttpStatus.OK);
    }

    @GetMapping("/{post-id}")
    public ResponseEntity show(@PathVariable("post-id") int postId){
        Post post = postService.show(postId);
        return new ResponseEntity(postMapper.postTopostDto(post), HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity create(@RequestBody PostDto postDto){

        Post post = postMapper.postdtoToPost(postDto);
        Post response = postService.create(post);
        return new ResponseEntity(postMapper.postTopostDto(response), HttpStatus.CREATED);
    }




    @PatchMapping("/{post-id}")
    public ResponseEntity update(@PathVariable("post-id") int postId,
                                 @RequestBody PostDto postDto){

        Post post = postMapper.postdtoToPost(postDto);
        Post response = postService.update(postId, post);
        return new ResponseEntity(HttpStatus.OK);
    }


    @DeleteMapping("/{post-id}")
    public ResponseEntity delete(@PathVariable("post-id") int postID){
        postService.delete(postID);
        return new ResponseEntity(HttpStatus.OK);
    }
}