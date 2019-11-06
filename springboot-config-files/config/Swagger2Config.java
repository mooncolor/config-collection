package cn.com.tcsec.saas.astp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author mengxu
 * @date 2019/9/2 15:31
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * 添加摘要信息(Docket)
     */
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(new ApiInfoBuilder()
                .title("标题：杭州孝道科技_iast_接口文档")
                .description("描述：用于统计展示漏洞信息")
                .version("版本号:1.0")
                .build())
            .select()
            .apis(RequestHandlerSelectors.basePackage("cn.com.tcsec.saas.astp"))
            .paths(PathSelectors.any())
            .build()
            .securitySchemes(securitySchemes());
    }

    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeyList= new ArrayList();
        apiKeyList.add(new ApiKey("token", "token", "header"));
//        apiKeyList.add(new ApiKey("secpointid", "secpointid", "cookie"));
        return apiKeyList;
    }
}
