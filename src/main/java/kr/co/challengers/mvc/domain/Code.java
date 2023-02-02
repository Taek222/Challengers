package kr.co.challengers.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
