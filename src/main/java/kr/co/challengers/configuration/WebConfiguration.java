package kr.co.challengers.configuration;

import kr.co.challengers.configuration.servlet.handler.BaseHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:/messages/message");
        source.setDefaultEncoding("UTF-8");
        source.setCacheSeconds(60);
        source.setDefaultLocale(Locale.KOREAN);
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }

    @Bean
    public BaseHandlerInterceptor baseHandlerInterceptor(){
        return new BaseHandlerInterceptor();
    }

    @Bean
    public GlobalConfig config(){
        return new GlobalConfig();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(baseHandlerInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        String resourcePattern = config().getUploadResourcePath() + "**";
        if(config().isLocal()){//로컬은 보통 윈도우환경
            registry.addResourceHandler(resourcePattern).addResourceLocations("file:///"+config().getUploadFilePath());
        }else{//개발, 운영은 보통 리눅스, 유닉스 환경
            registry.addResourceHandler(resourcePattern).addResourceLocations("file:"+config().getUploadFilePath());
        }
    }
}
