package kr.co.challengers.mvc.controller;

import io.swagger.annotations.Api;
import kr.co.challengers.configuration.exception.BaseException;
import kr.co.challengers.configuration.http.BaseResponse;
import kr.co.challengers.configuration.http.BaseResponseCode;
import kr.co.challengers.configuration.session.HttpSessionUser;
import kr.co.challengers.mvc.domain.ToDo;
import kr.co.challengers.mvc.domain.User;
import kr.co.challengers.mvc.parameter.ToDoRequestParameter;
import kr.co.challengers.mvc.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todo")
@Api(tags = "TODO API")
public class ToDoController {
    private final HttpSessionUser httpSessionUser;
    @Autowired
    private ToDoService todoService;

    @GetMapping("/today")
    public BaseResponse<List<ToDo>> getTodayToDo() {
        if(httpSessionUser.getAttribute()!=null) {
            String sessionUserId = httpSessionUser.getAttribute().getUserId();

            List<ToDo> dataset = todoService.getTodayToDo(
                    ToDoRequestParameter.builder()
                            .userId(sessionUserId)
                            .build());
            return BaseResponse.SuccessfulResult(dataset);
        }else {
            throw new BaseException(BaseResponseCode.LOGIN_REQUIRED);
        }
    }


}