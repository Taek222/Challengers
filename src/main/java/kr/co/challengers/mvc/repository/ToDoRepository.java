package kr.co.challengers.mvc.repository;

import kr.co.challengers.mvc.domain.ToDo;
import kr.co.challengers.mvc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository {
    List<ToDo> getTodayToDo(User user);

}