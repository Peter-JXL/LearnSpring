package com.peterjxl.jdbc;

import java.sql.*;

/**
 * 说明程序的耦合
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException {
        //1. 注册驱动
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        // Class.forName("com.mysql.cj.jdbc.Driver");

        //2. 获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnSpring", "learnSpringUser", "learnSpringPassword");

        //3. 获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");

        //4. 执行SQL，得到结果集
        ResultSet resultSet = pstm.executeQuery();

        //5. 遍历结果集
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        //6. 释放资源
        resultSet.close();
        pstm.close();
        conn.close();
    }
}
