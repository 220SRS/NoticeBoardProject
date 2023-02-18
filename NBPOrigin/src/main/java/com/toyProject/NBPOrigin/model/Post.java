package com.toyProject.NBPOrigin.model;

import com.toyProject.NBPOrigin.dto.PostDto;

import java.sql.Blob;

public class Post {


    int postId;
    String title;
    String body;
//    Blob img;



//    public Post(PostDto postDto) {
//        this.postId = postDto.getPostId();
//        this.title = postDto.getTitle();
//        this.body = postDto.getBody();
//        this.img = postDto.getImg();
//    }
//
//
//    public Post(int postId, String title, String body, Blob img) {
//        this.postId = postId;
//        this.title = title;
//        this.body = body;
//        this.img = img;
//    }

    public int getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

//    public Blob getImg() {
//        return img;
//    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

//    public void setImg(Blob img) {
//        this.img = img;
//    }
}

