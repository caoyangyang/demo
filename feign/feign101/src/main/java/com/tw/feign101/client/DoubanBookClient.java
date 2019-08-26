package com.tw.feign101.client;

import com.tw.feign101.response.BookResponse;
import com.tw.feign101.response.BookTitleResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "DoubanBookFeignClient",
        configuration = DefaultFeignClientConfiguration.class,
        url = "https://book.douban.com")
public interface DoubanBookClient {
    @GetMapping(value = "/j/subject_suggest")
    List<BookResponse> searchBooks(@RequestParam("q") String keyword);

    @GetMapping(value = "/j/subject/{bookId}")
    BookTitleResponse findBookTitleById(@PathVariable("bookId") String bookId);
}
