package com.cms.kernel.config;

import com.cms.kernel.util.MyMultipartResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipartResolverConfig {

    @Bean
    public MyMultipartResolver multipartResolver(){
        MyMultipartResolver myMultipartResolver = new MyMultipartResolver();
        myMultipartResolver.setMaxUploadSize(10240000);
        myMultipartResolver.setExcludeUrls("/admin/uploadBg");
        return myMultipartResolver;
    }
}
