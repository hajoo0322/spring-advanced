package org.example.develop.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PatchRequestCalendarDto {

    @Valid
    @NotNull
    private final RequestCalendarDto requestCalendarDto;

    @NotNull
    private final String newDetails;

    @JsonCreator
    public PatchRequestCalendarDto(
            @JsonProperty("request_calendar_dto")
            RequestCalendarDto requestCalendarDto,
            @JsonProperty("new_details")
            String newDetails)
    {
        this.requestCalendarDto = requestCalendarDto;
        this.newDetails = newDetails;
    }
}
