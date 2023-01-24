package kr.co.challengers.configuration.session;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class AbstractHttpSession<T> {

    //세션에 사용되는 이름
    protected abstract String name();

    public void setAttribute(T value){
        getSession().setAttribute(name(), value);
    }

    @SuppressWarnings("unchecked")
    public T getAttribute(){
        return (T) getSession().getAttribute(name());
    }

    public void removeAttribute(){
        getSession().removeAttribute(name());
    }

    public void invalidate(){
        getSession().invalidate();
    }

    protected HttpSession getSession(){
        return getRequest().getSession();
    }

    protected HttpServletRequest getRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes!=null){
            return((ServletRequestAttributes) requestAttributes).getRequest();
        }
        return null;
    }
}
