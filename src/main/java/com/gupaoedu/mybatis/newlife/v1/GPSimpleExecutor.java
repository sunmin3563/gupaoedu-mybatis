package com.gupaoedu.mybatis.newlife.v1;

import com.gupaoedu.mybatis.beans.Test;

import java.sql.*;

/**
 * @author sunmin
 * @date 2018/7/20 17:10
 */
public class GPSimpleExecutor implements GPExecutor{

    @Override
    public <T> T query(String statement, String parameter) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Test test = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gp?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            preparedStatement = connection.prepareStatement(String.format(statement,Integer.parseInt(parameter)));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                test = new Test();
                test.setId(rs.getInt(1));
                test.setNums(rs.getInt(2));
                test.setName(rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (T)test;
    }
}
