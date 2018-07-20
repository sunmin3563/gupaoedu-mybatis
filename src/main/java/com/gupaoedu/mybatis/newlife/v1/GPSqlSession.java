package com.gupaoedu.mybatis.newlife.v1;

/**
 * @author sunmin
 * @date 2018/7/20 15:34
 */
public class GPSqlSession {
    private GPConfiguration configuration;
    private GPExecutor executor;

    public GPSqlSession(GPConfiguration configuration, GPExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    /**
     * getMapper
     * @param clazz
     */
    public <T> T getMapper(Class<T> clazz){
       return configuration.getMapperper(clazz,this);
    }

    /**
     * @param statement sql语句
     * @param parameter sql参数
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statement,String parameter){
       return executor.query(statement,parameter);
    }
}
