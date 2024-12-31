package org.example.develop.service;

import org.example.develop.dto.PatchRequestComment;
import org.example.develop.dto.RequestCommentDto;
import org.example.develop.dto.ResponseCommentDto;
import org.example.develop.entity.CommentEntity;
import org.example.develop.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentCoreService implements CommentService {
    CommentRepository commentRepository;

    public CommentCoreService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public ResponseCommentDto addComment(RequestCommentDto requestCommentDto, Long userId) {
        CommentEntity commentEntity = new CommentEntity(userId, requestCommentDto);
        CommentEntity save = commentRepository.save(commentEntity);
        return new ResponseCommentDto(save);

    }

    @Override
    public List<ResponseCommentDto> getComment(Long calenderId) {
        List<CommentEntity> allByCalendarId = commentRepository.findAllByCalendarId(calenderId);

        return allByCalendarId.stream()
                .map(ResponseCommentDto::new).collect(Collectors.toList());

    }

    @Override
    public ResponseCommentDto updateComment(PatchRequestComment patchRequestComment) {
        CommentEntity commentEntity = commentRepository.findById(patchRequestComment.getCommentId()).orElseThrow(() -> new RuntimeException("해당 댓글을 찾을수 없습니다."));
        commentEntity.setComment(patchRequestComment.getNewComment());
        CommentEntity save = commentRepository.save(commentEntity);
        return new ResponseCommentDto(save);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
