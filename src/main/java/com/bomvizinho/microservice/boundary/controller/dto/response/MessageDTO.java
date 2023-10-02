package com.bomvizinho.microservice.boundary.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;

public class MessageDTO {

    private String message;

    @JsonCreator

    public MessageDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static final class Builder {
        private String message;

        private Builder() {
        }

        public static Builder aMessageDTO() {
            return new Builder();
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public MessageDTO build() {
            return new MessageDTO(message);
        }
    }

}
