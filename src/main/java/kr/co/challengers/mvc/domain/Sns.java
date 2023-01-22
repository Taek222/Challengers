package kr.co.challengers.mvc.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Sns {
    private String userId;
    private String postId;
    private String imagePath;
    private String status;
    private String delYn;
    private Date creDt;
    private String regUser;
    private Date modDt;
    private String modUser;
}
