package org.example.develop.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class RequestCalendarDto {
    @NotNull
    @Size(max = 10)
    private final String title;

    @NotNull
    private final String details;

    @JsonCreator
    public RequestCalendarDto(
            @JsonProperty("title") String title,
            @JsonProperty("details") String details
    ) {
        this.title = title;
        this.details = details;
    }
}
