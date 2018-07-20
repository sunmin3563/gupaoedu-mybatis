package com.gupaoedu.mybatis.newlife.v1;

import com.gupaoedu.mybatis.beans.Test;

/**
 * @author sunmin
 * @date 2018/7/20 16:56
 */
public interface TestMapper {
    Test selectByPrimaryKey(Integer userId);
}
