package com.tw.feign101.client;

import com.tw.feign101.request.BookKindRequest;
import com.tw.feign101.response.BookKindResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "DoubanReadFeignClient",
        configuration = DefaultFeignClientConfiguration.class,
        url = "https://read.douban.com")
public interface DoubanReadClient {
    @GetMapping(value = "/j/kind/")
    BookKindResponse getBooksAndSort(BookKindRequest bookKindRequest);
}
