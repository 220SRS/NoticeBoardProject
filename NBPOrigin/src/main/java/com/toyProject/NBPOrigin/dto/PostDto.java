package com.toyProject.NBPOrigin.dto;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Blob;


public class PostDto {

    int postId;

    String title;

    String body;

//    Blob img;

//    DateTime

    public PostDto(int postId, String title, String body) {
        this.postId = postId;
        this.title = title;
        this.body = body;
//        this.img = img;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

//    public Blob getImg() {
//        return img;
//    }
//
//    public void setImg(Blob img) {
//        this.img = img;
//    }
}
