package kr.co.challengers.configuration.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
공통으로 사용할 응답 클래스
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Data
public class BaseResponse<T> {

    private BaseResponseCode code;
    private String message;
    private int page;
    private int sortNum;
    private T data;

    public BaseResponse(T data) {
        this.code = BaseResponseCode.SUCCESS;
        this.data = data;
    }

    public BaseResponse(BaseResponseCode responseCode, String message){
        this.code = responseCode;
        this.message = message;
    }

    public static <T> BaseResponse<T> SuccessfulResult(T result) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(BaseResponseCode.SUCCESS);
        response.setMessage(BaseResponseMessage.SUCCESS);
        response.setData(result);
        return response;
    }

    public static <T> BaseResponse<List<T>> SuccessfulResult(List<T> resultList) {
        BaseResponse<List<T>> response = new BaseResponse<>();
        response.setCode(BaseResponseCode.SUCCESS);
        response.setMessage(BaseResponseMessage.SUCCESS);
        response.setData(resultList);
        return response;
    }

    public static <T> BaseResponse<List<T>> SuccessfulResult(List<T> resultList, int page, int sortNum) {
        BaseResponse<List<T>> response = new BaseResponse<>();
        response.setCode(BaseResponseCode.SUCCESS);
        response.setMessage(BaseResponseMessage.SUCCESS);
        response.setPage(page);
        response.setSortNum(sortNum);
        response.setData(resultList);
        return response;
    }
}
