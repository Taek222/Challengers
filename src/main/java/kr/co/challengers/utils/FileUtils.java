package kr.co.challengers.utils;

import kr.co.challengers.configuration.GlobalConfig;
import kr.co.challengers.configuration.exception.BaseException;
import kr.co.challengers.configuration.http.BaseResponse;
import kr.co.challengers.configuration.http.BaseResponseCode;
import kr.co.challengers.mvc.parameter.UploadFileParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

@Component
public class FileUtils {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GlobalConfig config;

    public BaseResponse<Boolean> uploadFiles(MultipartFile multipartFile){
        logger.debug("multipartFile : {}", multipartFile);
        if(multipartFile == null || multipartFile.isEmpty()){
            throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        }
        String currentDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        String uploadFilePath = config.getUploadFilePath() + currentDate + "/";
        logger.debug("uploadFilePath : {}", uploadFilePath);
        String prefix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1, multipartFile.getOriginalFilename().length());
        String filename = UUID.randomUUID().toString()+"."+prefix;
        logger.info("filename : {}", filename);
        File folder = new File(uploadFilePath);
        //폴더가 없다면 생성
        if(!folder.isDirectory()){
            folder.mkdir();
        }
        String pathname = uploadFilePath + filename;
        String resourcePathname = config.getUploadResourcePath() + currentDate + "/" + filename;
        File dest = new File(pathname);
        logger.debug("dest : {}", dest);
        try{
            multipartFile.transferTo(dest);
            UploadFileParameter parameter = new UploadFileParameter();
            parameter.setContentType(multipartFile.getContentType());
            parameter.setOriginalFilename(multipartFile.getOriginalFilename());
            parameter.setFilename(filename);
            parameter.setPathname(pathname);
            parameter.setSize((int)multipartFile.getSize());
            parameter.setResourcePathname(resourcePathname);
        }catch(Exception e){
            logger.error("e", e);
        }
        return new BaseResponse<Boolean>(true);
    }
}
