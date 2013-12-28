package com.jeklsoft.example;

import java.util.Date;
import java.util.Random;

public class RandomTargetGenerator implements ITargetGenerator {
    @Override
    public int generate(int highestValue) {
        return new Random(new Date().getTime()).nextInt(highestValue + 1);
    }
}
