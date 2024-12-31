package org.example.develop.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PatchRequestComment {

    @NotNull
    private final Long commentId;

    @NotNull
    private final String newComment;

    @JsonCreator
    public PatchRequestComment(
            @JsonProperty("comment_id") Long commentId,
            @JsonProperty("new_comment") String newComment) {
        this.commentId = commentId;
        this.newComment = newComment;
    }
}
