package org.example.develop.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.develop.dto.PatchRequestComment;
import org.example.develop.dto.RequestCommentDto;
import org.example.develop.dto.ResponseCommentDto;
import org.example.develop.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<ResponseCommentDto> addComment(@Valid @RequestBody RequestCommentDto requestCommentDto, HttpSession httpSession) {
        Long userId = (Long) httpSession.getAttribute("userId");
        return new ResponseEntity<>(commentService.addComment(requestCommentDto, userId), HttpStatus.OK);
    }

    @GetMapping("/calendar/{calendar_id}")
    public ResponseEntity<List<ResponseCommentDto>> getComment(@PathVariable("calendar_id") Long calendarId) {
        return new ResponseEntity<>(commentService.getComment(calendarId), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<ResponseCommentDto> updateComment(@Valid @RequestBody PatchRequestComment patchRequestComment) {
        return new ResponseEntity<>(commentService.updateComment(patchRequestComment), HttpStatus.OK);
    }

    @DeleteMapping("/{comment_id}")
    public ResponseEntity<Void> deleteComment(@PathVariable("comment_id") Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
