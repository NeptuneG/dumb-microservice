package com.dumb.microservice.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by guayu on 7/28/2017.
 */
@RestController
public class SampleServiceController {

    private static final String URL_PREFIX = "https://site.douban.com/";
    private static final String TARGET_LINE_PREFIX = "song_records";
    private int callCount = 0;

    class CallInfo {
        private int count;
        private String host;

        CallInfo(int count, String host) {
            this.count = count;
            this.host = host;
        }
    }

    @GetMapping("/sample/{urlSuffix}")
    public String getSongRecords(@PathVariable String urlSuffix) {
        callCount++;
        String ret = "[";
        try {
            URLConnection connection = new URL(URL_PREFIX + urlSuffix).openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith(TARGET_LINE_PREFIX)) {
                    ret += line.substring(line.indexOf("{"), line.length()-2) + ",";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{error:\""+ e.toString() +"\""+"}";
        }
        return ret.equals("[") ? "{}" : ret.substring(0, ret.length()-1) + "]";
    }

    @GetMapping("/sample/count")
    public String getCallCount() {

        try {
            Gson gson = new Gson();
            String hostname = InetAddress.getLocalHost().getHostName();
            CallInfo callInfo = new CallInfo(callCount, hostname);
            return gson.toJson(callInfo, CallInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "{}";
    }
}
