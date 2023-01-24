package kr.co.challengers.configuration.servlet.handler;

import kr.co.challengers.configuration.exception.BaseException;
import kr.co.challengers.configuration.http.BaseResponseCode;
import kr.co.challengers.configuration.web.bind.annotation.RequestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseHandlerInterceptor extends HandlerInterceptorAdapter {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        logger.info("preHandle requestURI : {}", request.getRequestURI());;
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            logger.info("handlerMethod : {}", handlerMethod);
            RequestConfig requestConfig = handlerMethod.getMethodAnnotation(RequestConfig.class);
            if(requestConfig != null){
                //로그인 체크가 필수인 경우
                if(requestConfig.loginCheck()){
                    throw new BaseException(BaseResponseCode.LOGIN_REQUIRED);
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
        logger.info("postHandle requestURI : {}", request.getRequestURI());

    }
}
