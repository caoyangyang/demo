package com.tw.feign101.client;

public class FeignException extends RuntimeException {
    public FeignException(String message) {
        super(message);
    }
}