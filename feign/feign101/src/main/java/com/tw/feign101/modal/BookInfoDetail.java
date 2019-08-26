package com.tw.feign101.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tw.feign101.modal.BookKind;
import com.tw.feign101.modal.People;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BookInfoDetail {
    @JsonProperty("abstract")
    private String abstractString;
    private List<People> author;
    private Double averageRating;
    private String editorHighlight;
    private List<String> highlightTags;
    
    private boolean isBundle;
    private boolean isColumn;
    private boolean isEssay;
    private boolean isInWishlist;
    private boolean isNew;
    private boolean isOrigin;
    private boolean isPurchased;
    private boolean isRebate;

    private String id;
    private String title;
    private String url;
    private String cover;
    private String wordCountUnit;
    
    
    private int ratingCount;
    private int wordCount;
    private int salesPrice;
    private int fixedPrice;
    
    private List<BookKind> kinds;
    private List<People> origAuthor;
    private List<People> translator;
}
