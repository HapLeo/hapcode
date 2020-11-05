package top.hapleow.hapcodeweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuyulin
 * @date 2020/11/5
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();

//        restTemplate.setRequestFactory(newBufferingClientHttpRequestFactory(clientHttpRequestFactory()));
//        restTemplate.setMessageConverters(Collections.singletonList(mappingJacksonHttpMessageConverter()));
//
//        restTemplate.setInterceptors( Collections.singletonList(newRequestResponseLoggingInterceptor()) );

        return restTemplate;
    }
}
