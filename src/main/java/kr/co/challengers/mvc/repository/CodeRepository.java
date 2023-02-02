package kr.co.challengers.mvc.repository;

import kr.co.challengers.mvc.domain.Code;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 공통코드 관리 Repository Interface
 */
@Repository
public interface CodeRepository {

    /**
     * <pre>
     * 그룹 코드 목록 조회
     * </pre>
     *
     * @return 그룹 코드 목록
     */
    List<Code> getGroupCodeList();

    /**
     * <pre>
     * 공통 코드 목록 조회
     * </pre>
     *
     * @param input 그룹코드 조회 조건
     * @return 공통 코드 목록
     */
    List<Code> getCodeList(Code input);
}
