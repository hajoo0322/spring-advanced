package org.example.develop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.example.develop.dto.RequestCommentDto;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


@Getter
@Entity
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long calendarId;

    @Setter
    private String comment;

    @CreatedDate
    private LocalDateTime createDateTime;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public CommentEntity() {

    }

    public CommentEntity(Long userId, RequestCommentDto requestCommentDto) {
        this.userId = userId;
        this.calendarId = requestCommentDto.getCalendarId();
        this.comment = requestCommentDto.getComment();
    }
}
