package kr.co.challengers.mvc.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SnsLIke {
    private String postId;
    private String likeUserId;
    private String delYn;
    private Date creDt;
    private String regUser;
    private Date modDt;
    private String modUser;
}
