package com.stormling.aop;

/**
 * @Author: StormLing
 * @Description:
 * @Date: Created in 11:29 2020-05-29
 * @Modified By:
 */
public class MathCalculator {
    public int div(int i, int j) {
        System.out.println("MathCalculator >> div");
        return i / j;
    }
}
