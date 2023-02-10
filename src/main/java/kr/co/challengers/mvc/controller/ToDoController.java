package kr.co.challengers.mvc.controller;

import kr.co.challengers.configuration.http.BaseResponse;
import kr.co.challengers.configuration.session.HttpSessionUser;
import kr.co.challengers.mvc.domain.ToDo;
import kr.co.challengers.mvc.domain.User;
import kr.co.challengers.mvc.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todo")
public class ToDoController {
    private final HttpSessionUser httpSessionUser;
    @Autowired
    private ToDoService todoService;

    @GetMapping("/today")
    public BaseResponse<List<ToDo>> getTodayToDo() {
        User user = new User();//나의 정보가 user 에 담긴걸로 생각
        user.setUserId(httpSessionUser.getAttribute().getUserId());//세션의 아이디 가져오기
        return new BaseResponse<List<ToDo>>(todoService.getTodayToDo(user));
    }


}