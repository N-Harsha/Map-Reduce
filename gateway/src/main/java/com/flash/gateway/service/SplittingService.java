package com.flash.gateway.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

@Service
public class SplittingService {
    public void split(int batchSize,  Consumer<List<List<String>>> handler){
        InputStream fis = getClass().getClassLoader().getResourceAsStream("Dataset.csv");
        assert fis != null;
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        List<List<String>> batch  = new ArrayList<>();
        Set<String> basket = new HashSet<>();

        String billNo = null;

        String line = null;
        try {
            br.readLine(); // this would skip the first line
            while ((line = br.readLine())!=null){
                String[] tokens = line.split(";");
                String currentBillNo = tokens[0];
                String ProductName = tokens[1];
                if(billNo == null||(!billNo.equals(currentBillNo))){
                    if(!basket.isEmpty()){
                        batch.add(basket.stream().toList());
                        basket = new HashSet<>();
                    }
                    if(batch.size() == batchSize){
//                        System.out.println(batch);
                        handler.accept(batch);
                        batch = new ArrayList<>();
                    }
                    billNo = currentBillNo;
                }
                basket.add(ProductName);
            }
            // handle dangling batch/basket
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
