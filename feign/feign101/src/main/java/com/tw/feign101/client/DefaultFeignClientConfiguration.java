package com.tw.feign101.client;

import com.tw.feign101.utils.DoubanFeignLogger;
import feign.Logger;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class DefaultFeignClientConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    Logger DoubanFeignLogger(){
        return new DoubanFeignLogger();
    }

    @Bean
    ServiceTokenHeaderInterceptor serviceTokenHeaderInterceptor() {
        return new ServiceTokenHeaderInterceptor();
    }

    @Bean
    public ErrorDecoder feignErrorDecoder() {
        return new CustomerErrorDecoder();
    }

    @Bean
    Retryer feignRetryer() {
        return new Retryer.Default();
//        return new CustomerFeignRetry();
    }
}
