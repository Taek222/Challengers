package kr.co.challengers.configuration;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.annotation.PostConstruct;
import java.util.Properties;

public class GlobalConfig {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ApplicationContext context;

    @Autowired
    private ResourceLoader resourceLoader;

    private String uploadFilePath;
    private String uploadResourcePath;

    private boolean local;
    private boolean dev;
    private boolean prod;

    @PostConstruct
    public void init(){
        String[] activeProfiles = context.getEnvironment().getActiveProfiles();
        String activeProfile = "local";
        if(!ObjectUtils.isEmpty(activeProfiles)){
            activeProfile = activeProfiles[0];
        }
        String resourcePath = String.format("classpath:globals/global-%s.properties", activeProfile);
        try{
            Resource resource = resourceLoader.getResource(resourcePath);
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);

            this.uploadFilePath = properties.getProperty("uploadFile.path");
            this.uploadResourcePath = properties.getProperty("uploadFile.resourcePath");
            this.local = activeProfile.equals("local");
            this.dev = activeProfile.equals("dev");
            this.prod = activeProfile.equals("prod");
        } catch(Exception e){
            logger.error("e", e);
        }

    }

    public String getUploadFilePath(){
        return uploadFilePath;
    }

    public String getUploadResourcePath(){
        return uploadResourcePath;
    }

    public boolean isLocal(){
        return local;
    }

    public boolean isDev(){
        return dev;
    }

    public boolean isProd(){
        return prod;
    }
}
