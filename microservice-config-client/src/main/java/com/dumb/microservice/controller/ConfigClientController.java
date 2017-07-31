package com.dumb.microservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by goss.beta on 2017/7/31.
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${property}")
    private String property;

    @GetMapping("/property")
    public String getProperty() {
        return property;
    }
}
