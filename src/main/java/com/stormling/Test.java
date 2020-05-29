package com.stormling;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @Author: StormLing
 * @Description:
 * @Date: Created in 23:18 2020-05-28
 * @Modified By:
 */
public class Test {
    @Autowired(required = false)
    @Resource
    private Student student;
}
