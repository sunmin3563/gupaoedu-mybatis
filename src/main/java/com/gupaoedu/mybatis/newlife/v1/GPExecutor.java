package com.gupaoedu.mybatis.newlife.v1;

/**
 * @author sunmin
 * @date 2018/7/20 15:36
 */
public interface GPExecutor {

    <T> T query(String statement, String parameter);
}
