package kr.co.challengers.mvc.service;
import kr.co.challengers.mvc.domain.User;

import kr.co.challengers.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    //사용자 목록
    public List<User> getList(){
        return userRepository.getList();
    }

    //사용자 상세정보
    public User get(String userId){
        return userRepository.get(userId);
    }

    //사용자 정보 저장
    public void save(User user){
        userRepository.save(user);
    }

    //사용자 정보 삭제
    public void delete(String userId){
        userRepository.delete(userId);
    }

}
