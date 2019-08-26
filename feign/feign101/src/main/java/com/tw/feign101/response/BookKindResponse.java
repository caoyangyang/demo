package com.tw.feign101.response;

import com.tw.feign101.modal.BookInfoDetail;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BookKindResponse {
    private List<BookInfoDetail> list;
    private Integer total;
}

