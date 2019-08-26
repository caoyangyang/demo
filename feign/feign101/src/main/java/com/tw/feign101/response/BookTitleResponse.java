package com.tw.feign101.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookTitleResponse {
    private String title;
}
