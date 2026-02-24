package com.flash.gateway.service;

import com.flash.gateway.dto.request.AnalyseRequest;
import com.flash.gateway.dto.response.AnalyseResponse;
import org.springframework.stereotype.Service;

@Service
public class AnalyseService {
    private final SplittingService splittingService;
    private final MessageService messageService;
    public AnalyseService(SplittingService splittingService, MessageService messageService) {
        this.splittingService = splittingService;
        this.messageService = messageService;
    }
    public AnalyseResponse analyse(AnalyseRequest request){
        splittingService.split(5, messageService::sendMessage);
        return null;
    }
}
