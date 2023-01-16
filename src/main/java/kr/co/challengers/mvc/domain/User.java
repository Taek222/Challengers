package kr.co.challengers.mvc.domain;

import lombok.Data;
import java.util.Date;

@Data
public class User {
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
}
