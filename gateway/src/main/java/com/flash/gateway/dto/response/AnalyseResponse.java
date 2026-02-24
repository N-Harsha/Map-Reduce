package com.flash.gateway.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AnalyseResponse {
    private List<String> baseItems;
    private List<String> associatedItems;
    private double confidence;
    private double support;
    private double lift;
    private String message;
}
