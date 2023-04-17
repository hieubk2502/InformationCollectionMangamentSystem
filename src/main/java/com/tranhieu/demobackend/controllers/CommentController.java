package com.tranhieu.demobackend.controllers;

import com.tranhieu.demobackend.entities.Comment;
import com.tranhieu.demobackend.payloads.ApiResponse;
import com.tranhieu.demobackend.payloads.CommentDto;
import com.tranhieu.demobackend.services.CommentService;
import com.tranhieu.demobackend.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    // create
    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId){
        CommentDto newComment = this.commentService.createComment(comment,postId);
        return new ResponseEntity<CommentDto>(newComment, HttpStatus.CREATED);
    }

    // delete
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<>(new ApiResponse("comment deleted successfully!!",true),HttpStatus.OK);
    }


}
