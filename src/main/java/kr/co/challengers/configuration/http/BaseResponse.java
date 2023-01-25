package kr.co.challengers.configuration.http;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
공통으로 사용할 응답 클래스
 */
@Data
public class BaseResponse<T> {

    private BaseResponseCode code;
    private String message;
    private T data;

    public BaseResponse(T data) {
        this.code = BaseResponseCode.SUCCESS;
        this.data = data;
    }

    public BaseResponse(BaseResponseCode responseCode, String message){
        this.code = responseCode;
        this.message = message;
    }

}
