package com.common.Method;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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

    public static JSONObject getJSONParam(HttpServletRequest request){
        JSONObject jsonParam = null;
        try{
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line = streamReader.readLine()) != null){
                sb.append(line);
            }
            jsonParam = JSONObject.parseObject(sb.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
        return jsonParam;
    }

}
