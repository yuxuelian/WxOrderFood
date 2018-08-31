package com.example.demo.simulate;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author kaibo
 * @date 2018/8/31 10:22
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

class JsonUtils {

    static SimulateData simulateData;

    static {
        try {
            Resource resource = new ClassPathResource("static/data.json");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String result;
            StringBuilder stringBuilder = new StringBuilder();
            while ((result = bufferedReader.readLine()) != null) {
                stringBuilder.append(result);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            simulateData = objectMapper.readValue(stringBuilder.toString(), SimulateData.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
