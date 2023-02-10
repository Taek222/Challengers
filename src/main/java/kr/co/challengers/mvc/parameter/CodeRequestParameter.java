package kr.co.challengers.mvc.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CodeRequestParameter {

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @ApiModel(value = "공통코드 등록 요청 모델")
    public class CodeCreateRequest {

        @ApiModelProperty(value = "그룹코드", example = "NOTIFICATIONTYPE", position = 1)
        private String comGrpCd;
        @ApiModelProperty(value = "코드", example = "CHALLENGE", position = 2)
        private String comCd;
        @ApiModelProperty(value = "코드명", example = "챌린지", position = 3)
        private String cdNm;
        @ApiModelProperty(value = "코드 설명", example = "챌린지", position =4)
        private String cdDesc;
        @ApiModelProperty(value = "기본값 여부", example = "Y", position = 5)
        private String defaultYn;

    }
}
