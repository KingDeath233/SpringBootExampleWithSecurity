package com.common.Method;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class UniversalMethod {

    public static Map<String, Object> generateResponseEntityBody(Object content, String message){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", message);
        body.put("content",content);
        body.put("status", true);
        return body;
    }

}
