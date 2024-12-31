package org.example.develop.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RequestCommentDto {

    @NotNull
    private final Long calendarId;

    @NotNull
    private final String comment;

    @JsonCreator
    public RequestCommentDto(
            @JsonProperty("calendar_id") Long calendarId,
            @JsonProperty("comment") String comment) {
        this.calendarId = calendarId;
        this.comment = comment;
    }
}
