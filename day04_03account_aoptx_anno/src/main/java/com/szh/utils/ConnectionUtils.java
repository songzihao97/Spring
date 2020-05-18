package com.szh.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接工具类，用于从数据源获取一个连接，并且实现和线程绑定
 */
@Component("connectionUtils")
public class ConnectionUtils {

    private ThreadLocal<Connection> tl=new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;

    public Connection getConnection(){
        try {
            //先从ThreadLocal获取
            Connection conn=tl.get();
            //判断当前线程是否有连接
            if(conn==null){
                conn=dataSource.getConnection();
                tl.set(conn);
            }
            //返回当前线程连接
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
