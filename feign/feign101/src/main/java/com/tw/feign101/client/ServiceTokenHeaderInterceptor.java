package com.tw.feign101.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.MDC;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class ServiceTokenHeaderInterceptor implements RequestInterceptor {
    public void apply(RequestTemplate template) {
        Map<String, String> map = Optional.ofNullable(MDC.getCopyOfContextMap()).orElse(Collections.emptyMap());
        template.header("AUTHORIZATION", "mockTokenByYangyang");
    }
}
