package kr.co.challengers.session;

import kr.co.challengers.mvc.domain.User;
import lombok.Data;

import java.util.Date;

@Data
public class SessionUser {
    private String userId;
    private String domain;
    private String userNm;
    private String password;
    private String levelOpen;
    private String cell;
    private String delYn;
    private Date creDt;
    private String regUser;
    private Date modDt;
    private String modUser;

    public void setUser(User user){
        this.userId = user.getUserId();
        this.domain = user.getDomain();
        this.userNm = user.getUserNm();
        this.password = user.getPassword();
        this.levelOpen = user.getLevelOpen();
        this.cell = user.getCell();
        this.delYn = user.getDelYn();
        this.creDt = user.getCreDt();
        this.regUser = user.getRegUser();
        this.modDt = user.getModDt();
        this.modUser = user.getModUser();
    }
}
