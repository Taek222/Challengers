package kr.co.challengers.mvc.repository;

import kr.co.challengers.mvc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository {

    int login(Map<String, Object> params);

    //사용자 목록
    List<User> getList();

    //사용자 상세정보
    User get(Map<String, Object> param);

    //사용자 정보 저장
    void save(User user);

    //사용자 정보 삭제
    void delete(String userId);
}
