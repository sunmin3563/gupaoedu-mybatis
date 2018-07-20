package com.gupaoedu.mybatis.newlife.v1;

import com.gupaoedu.mybatis.beans.Test;

/**
 * @author sunmin
 * @date 2018/7/20 17:17
 */
public class Entry {
    public static void main(String[] args) {
        GPSqlSession sqlSession = new GPSqlSession(new GPConfiguration(),
                new GPSimpleExecutor());
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        Test test = mapper.selectByPrimaryKey(1);
        System.out.println(test);
    }
}
