package kr.co.challengers.mvc.repository;

import kr.co.challengers.mvc.domain.Sns;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SnsRepository {

    List<Sns> getStoryList();
}
