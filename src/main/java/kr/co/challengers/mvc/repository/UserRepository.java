package kr.co.challengers.mvc.repository;

import kr.co.challengers.mvc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    //사용자 목록
    List<User> getList();

    //사용자 상세정보
    User get(String userId);

    //사용자 정보 저장
    void save(User user);

    //사용자 정보 삭제
    void delete(String userId);
}
