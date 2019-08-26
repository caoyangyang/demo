package com.tw.feign101.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharStreams;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;

@Slf4j
public class CustomerErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
            try {
                String body = CharStreams.toString(response.body().asReader());
                if (StringUtils.isBlank(body)) {
                    log.warn("Non successful response returned from client {}", response.toString());
                    return new FeignException(getFeignResponse(response).getErrorMessage());
                } else {
                    log.warn("Non successful response with not empty body returned from client {}",
                            response.toString());
                    JsonNode errorNode = new ObjectMapper().readValue(body, JsonNode.class);
                    return new FeignException(errorNode.get("errorCode").asText()
                            + errorNode.get("message").asText()
                            + errorNode.get("exception").asText());
                }
            } catch (Exception e) {
                log.error("service request decode error, {}", e.getMessage());
                return new FeignException(getFeignResponse(response).getErrorMessage());
            }
    }

    private FeignResponse getFeignResponse(Response response) {
        try {
            FeignResponse feignResponse = new ObjectMapper().readValue(response.body().asReader(), FeignResponse.class);
            return feignResponse;
        } catch (IOException e) {
            return FeignResponse.fromException(e);
        }
    }
}
