package kr.co.challengers.mvc.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Code {

    private String comGrpCd;
    private String comCd;
    private String cdNm;
    private String cdDesc;
    private String defaultYn;
    private String sort;
    private String delYn;
    private Date creDt;
    private String regUser;
    private Date modeDt;
    private String modUser;
}
