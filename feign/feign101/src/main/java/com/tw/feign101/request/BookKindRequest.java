package com.tw.feign101.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookKindRequest {
    private String sort;
    private int kind;
    private int page;
    private String query;

}
