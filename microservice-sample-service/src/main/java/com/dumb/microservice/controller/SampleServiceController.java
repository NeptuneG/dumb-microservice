package com.dumb.microservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by guayu on 7/28/2017.
 */
@RestController
public class SampleServiceController {

    private static final String URL_PREFIX = "https://site.douban.com/";
    private static final String TARGET_LINE_PREFIX = "song_records";

    @RequestMapping(value = "/sample/{urlSuffix}", method = RequestMethod.GET)
    public String getSongRecords(@PathVariable("urlSuffix") String urlSuffix ) {
        try {
            URLConnection connection = new URL(URL_PREFIX + urlSuffix).openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith(TARGET_LINE_PREFIX)) {
                    return line.substring(line.indexOf("["), line.length()-1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{" +
                   "    \"error\":\""+ e.toString() +"\"" +
                   "}";
        }
        return "{}";
    }
}
