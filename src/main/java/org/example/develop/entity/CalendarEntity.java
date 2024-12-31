package org.example.develop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.develop.dto.RequestCalendarDto;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class CalendarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


    @OneToMany
    @JoinColumn(name = "calendar_id")
    private List<CommentEntity> commentEntityList;

    @Setter
    private String title;
    @Setter
    private String details;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public CalendarEntity() {
    }

    public CalendarEntity(UserEntity userEntity, RequestCalendarDto requestCalendarDto) {
        this.user = userEntity;
        this.title = requestCalendarDto.getTitle();
        this.details = requestCalendarDto.getDetails();
    }

}
