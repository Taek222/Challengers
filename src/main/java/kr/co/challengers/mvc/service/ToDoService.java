package kr.co.challengers.mvc.service;

import kr.co.challengers.mvc.domain.ToDo;
import kr.co.challengers.mvc.domain.User;
import kr.co.challengers.mvc.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository todoRepository;
    // 오늘의 todoList
    public List<ToDo> getTodayToDo(User param) { return todoRepository.getTodayToDo(param);}


}