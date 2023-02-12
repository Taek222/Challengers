package kr.co.challengers.mvc.parameter;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class ToDoRequestParameter {
    private int todoId;
    private String userId;
    private String title;
    private String status;
    private Date execDt;
    private String delYn;
}


