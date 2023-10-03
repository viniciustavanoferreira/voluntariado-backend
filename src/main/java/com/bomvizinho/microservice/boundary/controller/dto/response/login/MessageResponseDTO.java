package com.bomvizinho.microservice.boundary.controller.dto.response.login;

import com.fasterxml.jackson.annotation.JsonCreator;

public class MessageResponseDTO {

    private String message;

    @JsonCreator

    public MessageResponseDTO(String message) {
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

        public MessageResponseDTO build() {
            return new MessageResponseDTO(message);
        }
    }

}
