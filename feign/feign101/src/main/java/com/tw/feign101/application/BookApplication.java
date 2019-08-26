package com.tw.feign101.application;

import com.tw.feign101.client.DoubanBookClient;
import com.tw.feign101.client.DoubanReadClient;
import com.tw.feign101.request.BookKindRequest;
import com.tw.feign101.response.BookKindResponse;
import com.tw.feign101.response.BookResponse;
import com.tw.feign101.response.BookTitleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class BookApplication {
    private final DoubanBookClient doubanBookClient;
    private final DoubanReadClient doubanReadClient;
    public static final String queryString = "\n    query getFilterWorksList($works_ids: [ID!]) {\n      worksList(worksIds: $works_ids) {\n        \n    \n    title\n    cover\n    url\n    isBundle\n  \n    \n    url\n    title\n  \n    \n    author {\n      name\n      url\n    }\n    origAuthor {\n      name\n      url\n    }\n    translator {\n      name\n      url\n    }\n  \n    \n    abstract\n    editorHighlight\n  \n    \n    isOrigin\n    kinds {\n      \n    name @skip(if: true)\n    shortName @include(if: true)\n    id\n  \n    }\n    ... on WorksBase @include(if: true) {\n      wordCount\n      wordCountUnit\n    }\n    ... on WorksBase @include(if: true) {\n      \n    isEssay\n    \n    ... on EssayWorks {\n      favorCount\n    }\n  \n    \n    isNew\n    \n    averageRating\n    ratingCount\n    url\n  \n  \n  \n    }\n    ... on WorksBase @include(if: false) {\n      isColumn\n      isEssay\n      onSaleTime\n      ... on ColumnWorks {\n        updateTime\n      }\n    }\n    ... on WorksBase @include(if: true) {\n      isColumn\n      ... on ColumnWorks {\n        isFinished\n      }\n    }\n    ... on EssayWorks {\n      essayActivityData {\n        \n    title\n    uri\n    tag {\n      name\n      color\n      background\n      icon2x\n      icon3x\n      iconSize {\n        height\n      }\n      iconPosition {\n        x y\n      }\n    }\n  \n      }\n    }\n    highlightTags {\n      name\n    }\n  \n    ... on WorksBase @include(if: false) {\n      \n    fixedPrice\n    salesPrice\n    isRebate\n  \n    }\n    ... on EbookWorks {\n      \n    fixedPrice\n    salesPrice\n    isRebate\n  \n    }\n    ... on WorksBase @include(if: true) {\n      ... on EbookWorks {\n        id\n        isPurchased\n        isInWishlist\n      }\n    }\n  \n        id\n        isOrigin\n      }\n    }\n  ";


    @Autowired
    public BookApplication(DoubanBookClient doubanBookClient, DoubanReadClient doubanReadClient) {
        this.doubanBookClient = doubanBookClient;
        this.doubanReadClient  = doubanReadClient;
    }

    public List<BookResponse> search(String keyword) {
        log.info("search books by keyword {}",keyword);
        return doubanBookClient.searchBooks(keyword);
    }

    public BookTitleResponse getTitleByBookId(String bookId) {
        log.info("get book title by id {}",bookId);
        return doubanBookClient.findBookTitleById(bookId);
    }

    public BookKindResponse getHotBookByPage(int page, String sort) {
        log.info("get hot books for page {}",page);
        BookKindRequest bookKindRequest = BookKindRequest.builder()
                .page(page)
                .kind(109)
                .sort(sort)
                .query(queryString)
                .build();
        return doubanReadClient.getBooksAndSort(bookKindRequest);
    }


}
