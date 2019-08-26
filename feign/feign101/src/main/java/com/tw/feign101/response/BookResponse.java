package com.tw.feign101.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookResponse {
    private String title;
    private String url;
    private String pic;
    @JsonProperty("author_name")
    private String authorName;
    private String year;
    private String type;
    private String id;
}
