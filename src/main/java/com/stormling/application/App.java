package com.stormling.application;

import com.stormling.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: StormLing
 * @Description:
 * @Date: Created in 22:12 2020-05-28
 * @Modified By:
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = context.getBean(Student.class);

        System.out.println(student.getName()+"准备做作业了");
        student.doHomeWork();

        context.close();

    }
}
