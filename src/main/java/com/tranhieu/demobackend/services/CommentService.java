package com.tranhieu.demobackend.services;

import com.tranhieu.demobackend.payloads.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Integer postId);
    void deleteComment(Integer commentId);

}
