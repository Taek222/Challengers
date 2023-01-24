package kr.co.challengers.mvc.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SnsCategory {
    private String postId;
    private String seq;
    private String category;
    private String delYn;
    private Date creDt;
    private String regUser;
    private Date modDt;
    private String modUser;
}
