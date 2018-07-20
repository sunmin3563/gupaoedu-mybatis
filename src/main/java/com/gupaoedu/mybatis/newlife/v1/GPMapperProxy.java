package com.gupaoedu.mybatis.newlife.v1;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sunmin
 * @date 2018/7/20 16:44
 */
public class GPMapperProxy implements InvocationHandler{
    private GPSqlSession sqlSession;

    public GPMapperProxy(GPSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getDeclaringClass().getName().equals(GPConfiguration.TestMapperXml.namespace)){
            String sql = GPConfiguration.TestMapperXml.methodSqlMapping.get(method.getName());
            return sqlSession.selectOne(sql,String.valueOf(args[0]));
        }
        return method.invoke(this,args);
    }

}
