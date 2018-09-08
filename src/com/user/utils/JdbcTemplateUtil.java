package com.user.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * TODO
 *
 * @author Demon
 * @date 2018/9/7 9:48
 */
public class JdbcTemplateUtil {
    private static DataSource dataSource = new ComboPooledDataSource();
    private static DataSource adminDataSource = new ComboPooledDataSource("admin");

    public static JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    public static JdbcTemplate getAdminJdbcTemplate() {
        return new JdbcTemplate(adminDataSource);
    }
}
