package com.jonas.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 参数解析
 *
 * @author zwp
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter4 converter = new FastJsonHttpMessageConverter4();
        return new HttpMessageConverters(converter);
    }
}