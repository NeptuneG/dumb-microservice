package com.dumb.microservice.controller;

import com.dumb.microservice.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by goss.beta on 2017/7/28.
 */
@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;

    @GetMapping("/ribbon/{urlSuffix}")
    public String getSongRecords(@PathVariable String urlSuffix) {
        return this.ribbonService.getSongRecords(urlSuffix);
    }

    @GetMapping("/ribbon/count")
    public String getCallInfo() {
        return this.ribbonService.getCallInfo();
    }
}
