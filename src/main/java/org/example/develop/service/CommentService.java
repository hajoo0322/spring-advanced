package org.example.develop.service;


import org.example.develop.dto.PatchRequestComment;
import org.example.develop.dto.RequestCommentDto;
import org.example.develop.dto.ResponseCommentDto;

import java.util.List;

public interface CommentService {

    ResponseCommentDto addComment(RequestCommentDto requestCommentDto, Long userId);

    List<ResponseCommentDto> getComment(Long calendarId);

    ResponseCommentDto updateComment(PatchRequestComment patchRequestComment);

    void deleteComment(Long id);
}
