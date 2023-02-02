package kr.co.challengers.mvc.repository;

import kr.co.challengers.mvc.domain.Code;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeRepository {

    /**
     * <pre>
     * 공통 코드 목록 조회
     * </pre>
     *
     * @param input 그룹코드 조회 조건 (예: 그룹코드, 사용여부 등)
     * @return 조회 조건에 해당하는 공통 코드 목록
     */
    public List<Code> getCodeList(Code input);
}
