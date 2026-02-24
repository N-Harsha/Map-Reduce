package com.flash.gateway.dto.request;

import lombok.Data;
import java.util.Set;

@Data
public class AnalyseRequest {
    Set<String> baseItems;
    Set<String> associatedItems;
}
