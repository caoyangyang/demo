package com.tw.feign101.utils;

import feign.Request;
import feign.Response;
import feign.Util;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static feign.Util.UTF_8;
import static feign.Util.decodeOrDefault;
import static feign.Util.valuesOrEmpty;

@Slf4j
public class DoubanFeignLogger extends feign.Logger {

    @Override
    protected void log(String configKey, String format, Object... args) {
    }

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        if (logLevel.ordinal() >= Level.HEADERS.ordinal()) {
            log.info(
                    "\n" +
                            "===========================request begin=============================================\n"
                            + "Name  : {}\n"
                            + "URI         : {}\n"
                            + "Method      : {}\n"
                            + "Headers     : {}\n"
                            + "Request body: {}\n"
                            + "==========================request end================================================\n",
                    configKey,
                    request.url(),
                    request.method(),
                    request.headers(),
                    (request.charset() != null & request.body() != null) ? new String(request.body(), request.charset()) : null
            );
        }
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response,
                                              long elapsedTime) throws IOException {
        int status = response.status();
        if (logLevel.ordinal() >= Level.HEADERS.ordinal()) {

            Response.Body responseBody = response.body();
            byte[] bodyData = Util.toByteArray(response.body().asInputStream());
            int bodyLength = bodyData.length;
            for (String field : response.headers().keySet()) {
                for (String value : valuesOrEmpty(response.headers(), field)) {
                    log(configKey, "%s: %s", field, value);
                }
            }
            log.info( "\n"+
                            "============================response begin==========================================\n"
                            + "method tag   : {}\n"
                            + "Status code  : {}\n"
                            + "Headers      : {}\n"
                            + "Response body: {}\n"
                            + "=======================response end=================================================",
                    configKey,
                    response.status(),
                    response.headers(),
                    (responseBody != null && !(status == 204 || status == 205)) && bodyLength > 0 ?
                            decodeOrDefault(bodyData, UTF_8, "Binary data") : null
            );
            return response.toBuilder().body(bodyData).build();
        }
        return response;
    }
}