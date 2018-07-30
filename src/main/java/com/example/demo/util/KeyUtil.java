package com.example.demo.util;

import java.util.Random;

/**
 * @author Administrator
 * @date 2018/7/29 23:13
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

public class KeyUtil {

    /**
     * 生成主键
     *
     * @return
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        String currentTimeMillis = String.valueOf(System.currentTimeMillis());
        Integer number = random.nextInt(900000) + 100000;
        return currentTimeMillis + number;
    }

}
