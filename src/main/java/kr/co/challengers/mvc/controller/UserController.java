package kr.co.challengers.mvc.controller;

import kr.co.challengers.mvc.domain.User;
import kr.co.challengers.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //사용자 목록
    @GetMapping
    public List<User> getList(){
        return userService.getList();
    }

    //사용자 상세정보
    @GetMapping("/{userId}")
    public User get(@PathVariable String userId){
        return userService.get(userId);
    }

    //사용자 정보 등록/수정 저장
    @GetMapping("/save")
    public void save(User user){
        userService.save(user);
    }

    //사용자 정보 삭제
    @GetMapping("/delete")
    public void delete(String userId){
        userService.delete(userId);
    }

}
