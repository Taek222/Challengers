package kr.co.challengers.mvc.service;
import kr.co.challengers.mvc.domain.User;

import kr.co.challengers.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(Map<String, Object> param){
        int chk = userRepository.login(param);
        if(chk == 1){
            return userRepository.get(param);
        }
        return null;
    }

    //사용자 목록
    public List<User> getList(){
        return userRepository.getList();
    }

    //사용자 상세정보
    public User get(Map<String, Object> param){
        return userRepository.get(param);
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
