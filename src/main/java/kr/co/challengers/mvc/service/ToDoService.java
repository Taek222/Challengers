package kr.co.challengers.mvc.service;

import kr.co.challengers.configuration.http.BaseResponse;
import kr.co.challengers.mvc.domain.ToDo;
import kr.co.challengers.mvc.domain.User;
import kr.co.challengers.mvc.parameter.ToDoRequestParameter;
import kr.co.challengers.mvc.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository todoRepository;
    // 오늘의 todoList
    public List<ToDo> getTodayToDo(ToDoRequestParameter param) {
        return todoRepository.getTodayToDo(param);
    }
}