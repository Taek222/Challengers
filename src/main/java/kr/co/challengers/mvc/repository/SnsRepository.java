package kr.co.challengers.mvc.repository;

import kr.co.challengers.mvc.domain.Sns;
import kr.co.challengers.mvc.parameter.SnsRequestParameter;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SnsRepository {

    List<Sns> getStoryFList(SnsRequestParameter param);
    List<Sns> getRandomStory(SnsRequestParameter param);
}
