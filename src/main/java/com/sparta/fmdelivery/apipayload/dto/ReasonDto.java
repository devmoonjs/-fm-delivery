package com.sparta.fmdelivery.apipayload.dto;

import com.sparta.fmdelivery.apipayload.status.SuccessStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@RequiredArgsConstructor
public class ReasonDto {

    private final String statusCode;
    private final String message;
    private final HttpStatus httpStatus;
    private final Boolean success;
}
