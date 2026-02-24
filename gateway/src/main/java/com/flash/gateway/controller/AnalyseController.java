package com.flash.gateway.controller;

import com.flash.gateway.dto.request.AnalyseRequest;
import com.flash.gateway.dto.response.AnalyseResponse;
import com.flash.gateway.service.AnalyseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("analyse")
public class AnalyseController {

    private final AnalyseService analyseService;

    public AnalyseController(AnalyseService analyseService) {
        this.analyseService = analyseService;
    }

    @PostMapping
    public ResponseEntity<AnalyseResponse> analyse(@RequestBody AnalyseRequest request){
        AnalyseResponse response = analyseService.analyse(request);
        return ResponseEntity.ok(response);
    }


}
