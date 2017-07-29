package com.dumb.microservice.service;

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

    public String getSongRecords(String urlSuffix) {
        return this.restTemplate.getForObject("http://MICROSERVICE-SAMPLE-SERVICE/sample/" + urlSuffix, String.class);
    }

    public String getCallInfo() {
        return this.restTemplate.getForObject("http://MICROSERVICE-SAMPLE-SERVICE/sample/count", String.class);
    }
}
