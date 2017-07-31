package com.dumb.microservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by goss.beta on 2017/7/28.
 */
@Service
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(RibbonService.class);

    @HystrixCommand(fallbackMethod = "getSongRecordsFallback")
    public String getSongRecords(String urlSuffix) {
        return this.restTemplate.getForObject("http://MICROSERVICE-SAMPLE-SERVICE/sample/" + urlSuffix, String.class);
    }

    public String getCallInfo() {
        return this.restTemplate.getForObject("http://MICROSERVICE-SAMPLE-SERVICE/sample/count", String.class);
    }

    public String getSongRecordsFallback(String urlSuffix, Throwable e) {
        RibbonService.LOGGER.error("Exception when accessing https://site.douban.com/{} : {}", urlSuffix, e.getMessage());
        return e.getMessage();
    }
}
