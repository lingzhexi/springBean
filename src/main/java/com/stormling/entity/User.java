package com.stormling.entity;

import lombok.Data;

/**
 * @Author: StormLing
 * @Description:
 * @Date: Created in 9:29 2020-05-29
 * @Modified By:
 */
@Data
public class User {
    private String id;
    private String lastName;
    private int age;
    private String email;
    @Override
    public String toString() {
        return "User [id=" + id + ", lastName=" + lastName + ", email=" + email + ", age=" + age +"] ";
    }
}
