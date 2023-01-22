package kr.co.challengers.configuration.web.bind.annotation;

import com.google.common.base.Utf8;
import io.swagger.annotations.ResponseHeader;
import jdk.jfr.ContentType;
import kr.co.challengers.configuration.exception.BaseException;
import kr.co.challengers.configuration.http.BaseResponse;
import kr.co.challengers.configuration.http.BaseResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BaseControllerAdvice {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(value = {BaseException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    private BaseResponse<?> handlerBaseException(BaseException e, WebRequest request){
        return new BaseResponse<String>(e.getResponseCode(), messageSource.getMessage(e.getResponseCode().name(), e.getArgs(), null));
    }
}
