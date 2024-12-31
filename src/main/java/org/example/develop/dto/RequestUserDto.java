package org.example.develop.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class RequestUserDto {

    @NotNull
    @NotBlank
    @Size(max = 4)
    private final String name;

    @NotNull
    @Email
    private final String email;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private final String password;

    @JsonCreator
    public RequestUserDto(
            @JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("password") String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
