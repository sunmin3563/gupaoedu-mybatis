package com.gupaoedu.mybatis.newlife.v1;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunmin
 * @date 2018/7/20 15:38
 */
public class GPConfiguration {

    public <T> T getMapperper(Class<T> clazz, GPSqlSession gpSqlSession) {
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new GPMapperProxy(gpSqlSession));
    }

    /**
     * 1.xml解析好了
     */
    static  class TestMapperXml{
        public static final String namespace = "com.gupaoedu.mybatis.newlife.v1.TestMapper";
        public static final Map<String,String> methodSqlMapping = new HashMap<String,String>();

        static {
            methodSqlMapping.put("selectByPrimaryKey","select * from test where id =%d");
        }
    }

}
