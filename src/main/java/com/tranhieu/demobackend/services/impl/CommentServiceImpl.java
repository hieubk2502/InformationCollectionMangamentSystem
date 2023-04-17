package com.tranhieu.demobackend.services.impl;

import com.tranhieu.demobackend.entities.Comment;
import com.tranhieu.demobackend.entities.Post;
import com.tranhieu.demobackend.exceptions.ResourceNotFoundException;
import com.tranhieu.demobackend.payloads.CommentDto;
import com.tranhieu.demobackend.repositories.CommentRepo;
import com.tranhieu.demobackend.repositories.PostRepo;
import com.tranhieu.demobackend.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post","postId",postId));
        Comment comment = this.modelMapper.map(commentDto,Comment.class);
        comment.setPost(post);
        Comment saveComment = this.commentRepo.save(comment);
        return this.modelMapper.map(saveComment,CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment =this.commentRepo.findById(commentId)
                .orElseThrow(()->new ResourceNotFoundException("comment","commentId",commentId));
        this.commentRepo.delete(comment);
    }
}
