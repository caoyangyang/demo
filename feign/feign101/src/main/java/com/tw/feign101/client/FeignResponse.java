package com.tw.feign101.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FeignResponse {
    @JsonProperty("r")
    private String errorMessage;

    private int code;

    public static FeignResponse fromException(Exception e) {
        return FeignResponse.builder()
                .code(0)
                .errorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value() + "-" + e.getMessage())
                .build();
    }

    public Boolean isSuccess() {
        return code == 0;
    }

    public String getErrorMessage(){
        return this.errorMessage;
    }
}
