package com.tw.feign101.modal;

public enum SortMethod {
    PRICE_ASE("price_asc"),
    RATING("rating"),
    NEW("new"),
    SALES("sales"),
    HOT("hot");
    private final String value;
    SortMethod(String value) {
        this.value = value;
    }
}
