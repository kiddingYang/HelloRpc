package com.tg.rpc.breaker;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by twogoods on 2017/7/23.
 */
@Data
public class BreakerProperty {
    private int poolSize = Runtime.getRuntime().availableProcessors() * 2;
    private List<String> clazz = new ArrayList<>();
    private long calculateWindowInMillis = 3000l;
    private int bucketNum = 10;
    private float errorPercentageThreshold = 0.5f;
    private int requestCountThreshold = 60;
    private long singleTestWindowInMillis = 20000l;

    public BreakerProperty addClass(String className) {
        clazz.add(className);
        return this;
    }

    public BreakerProperty addClass(List<String> classes) {
        clazz.addAll(classes);
        return this;
    }
}
