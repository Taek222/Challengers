package kr.co.challengers.configuration.session;

import kr.co.challengers.mvc.domain.User;
import kr.co.challengers.session.SessionUser;
import org.springframework.stereotype.Component;

@Component
public class HttpSessionUser extends AbstractHttpSession<SessionUser> {

    @Override
    protected String name(){
        return "SESSION_USER";
    }
}
