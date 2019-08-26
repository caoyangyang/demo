package com.tw.feign101.controller;

import com.tw.feign101.application.BookApplication;
import com.tw.feign101.response.BookKindResponse;
import com.tw.feign101.response.BookResponse;
import com.tw.feign101.response.BookTitleResponse;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@Setter
@RequestMapping("/books")
public class BookController {
    private final BookApplication bookApplication;

    @GetMapping("/search")
    public List<BookResponse> getByKeyword(@RequestParam("query") String keyword) {
        return bookApplication.search(keyword);
    }

    @GetMapping("/{bookId}/title")
    public BookTitleResponse getBookTitleById(@PathVariable("bookId") String bookId) {
        return bookApplication.getTitleByBookId(bookId);
    }

    @GetMapping("/all")
    public BookKindResponse getBookTitleById(@RequestParam("page") int page, @RequestParam("sort") String sort) {
        return bookApplication.getHotBookByPage(page, sort);
    }
}
