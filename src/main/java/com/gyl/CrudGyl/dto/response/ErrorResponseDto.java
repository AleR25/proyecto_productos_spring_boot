package com.gyl.CrudGyl.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorResponseDto
{
    private String message;
    private int status;
    private LocalDateTime fecha;
}
