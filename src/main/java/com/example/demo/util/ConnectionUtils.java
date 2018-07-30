package com.example.demo.util;

import java.util.Collection;

/**
 * @author Administrator
 * @date 2018/7/30 23:35
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

public class ConnectionUtils {

    public static <T> boolean isEmpty(Collection<T> collection) {
        if (collection == null) {
            return true;
        }

        return collection.isEmpty();
    }

}
