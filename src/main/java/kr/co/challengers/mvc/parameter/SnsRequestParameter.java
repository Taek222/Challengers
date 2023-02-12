package kr.co.challengers.mvc.parameter;

import kr.co.challengers.mvc.domain.Category;
import lombok.*;

import java.util.Date;
import java.util.List;

//@Builder
@Data
public class SnsRequestParameter {
    private String userId;
    private String postId;
    private List<String> categoryList;
    private String imagePath;
    private String status;
    private String delYn;
}





