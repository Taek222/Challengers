package kr.co.challengers.mvc.domain;

import lombok.Data;
import java.util.Date;

@Data
public class ToDo {
    private int todoId;
    private String title;
    private Date execDt;
    private String delYn;
    private Date creDt;
    private String regUser;
    private Date modDt;
    private String modUser;
}