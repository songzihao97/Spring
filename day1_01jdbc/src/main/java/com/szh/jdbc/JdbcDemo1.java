package com.szh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?serverTimezone=UTC","root","123456");
        //3.获取操作数据库预处理
        String sql = "select * from account";
        PreparedStatement pstm = connection.prepareStatement(sql);
        //4.执行sql获得结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        connection.close();
    }
}
