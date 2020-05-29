package com.stormling.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author: StormLing
 * @Description:
 * @Date: Created in 9:55 2020-05-29
 * @Modified By:
 */
@Configuration
public class JdbcTemplateDemo {
    //    获得不到jdbcTemplate的值
    @Bean
    public JdbcTemplate getJdbcTemplate(){
        ComboPooledDataSource db = new ComboPooledDataSource();
        return new JdbcTemplate(db);
    }
    public int testInsert(String name){
        String sql = "INSERT INTO xwj_user(id, name, age) VALUES(?, ?, ?)";
        int result = getJdbcTemplate().update(sql, "2", name, 26);
        return result;
    }
    public static void main(String[] args) {
        JdbcTemplateDemo jdbcTemplateDemo = new JdbcTemplateDemo();
        int storm = jdbcTemplateDemo.testInsert("storm");
        System.out.println(storm);
    }

}
