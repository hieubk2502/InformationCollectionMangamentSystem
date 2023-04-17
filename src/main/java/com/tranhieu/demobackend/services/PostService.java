package com.tranhieu.demobackend.services;

import com.tranhieu.demobackend.entities.Post;
import com.tranhieu.demobackend.payloads.PostDto;
import com.tranhieu.demobackend.payloads.PostResponse;

import java.util.List;

public interface PostService {

    //////////////////////////////////
    // create
    PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
    // update
    PostDto updatePost(PostDto postDto, Integer postId);
    // delete
    void deletePost(Integer postId);

    // get all post
    PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy, String sortDir);
    // get single post
    PostDto getPostById(Integer postId);

    /////////////////////////////////////////
    // get all post by category
    List<PostDto> getPostsByCategory(Integer categoryId);
    // get all post by user
    List<PostDto> getPostsByUser(Integer userId);
    // search posts
    List<PostDto> searchPosts(String keyword);
    //

}
