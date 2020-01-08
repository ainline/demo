package com.alchen.spring.aop.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接工具类，从数据源获取连接，绑定线程
 */
@Component
public class ConnectionUtil {

    private ThreadLocal<Connection> tl = new ThreadLocal<>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     *  获取线程上的连接
     */
    public Connection getTreadConnection() {
        Connection conn = null;
        try {
            // 1.从ThreadLocal上获取连接
            conn = tl.get();
            if (conn == null) {
                // 2.如果ThreadLocal上没有连接，则从数据源创建连接，设置到ThreadLocal中
                conn = dataSource.getConnection();
                tl.set(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 连接线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
