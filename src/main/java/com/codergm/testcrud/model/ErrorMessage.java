package com.codergm.testcrud.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorMessage {

    private HttpStatus status;
    private String message;
    private LocalDateTime time;

}
