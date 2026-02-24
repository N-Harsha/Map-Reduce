package com.flash.gateway.service;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.function.Consumer;

public class SplittingServiceTest {
    @Test
    public void testSplitPrintOutput() {
        SplittingService service = new SplittingService();
        int batchSize = 5;
//        service.split(batchSize,System.out::println);
    }
}

