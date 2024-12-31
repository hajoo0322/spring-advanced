package org.example.develop.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import org.example.develop.entity.CalendarEntity;

import java.time.LocalDateTime;

@Getter
@JsonRootName(value = "나는 바보야")

public class ResponseCalendarDto {
    private final Long id;
    private final String title;
    private final String details;
    private final LocalDateTime createdDate;
    private final LocalDateTime lastModifiedDate;

    public ResponseCalendarDto(CalendarEntity calendarEntity) {
        id = calendarEntity.getId();
        title = calendarEntity.getTitle();
        details = calendarEntity.getDetails();
        createdDate = calendarEntity.getCreatedDate();
        lastModifiedDate = calendarEntity.getLastModifiedDate();
    }
}
