package kr.co.challengers.mvc.repository;

import kr.co.challengers.mvc.domain.Code;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeRepository {

    List<Code> getCodeList();
}
