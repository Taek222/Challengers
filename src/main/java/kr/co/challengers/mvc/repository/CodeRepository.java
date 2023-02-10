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
     * 그룹코드 목록 조회
     * </pre>
     */
    List<Code> getGroupCodeList();

    /**
     * <pre>
     * 공통코드 목록 조회
     * </pre>
     */
    List<Code> getCodeList(Code input);

    /**
     * <pre>
     * 공통코드 사용여부 변경
     * </pre>
     */
    void updateCodeUseYn(Code input);

    /**
     * <pre>
     * 공통코드 삭제
     * </pre>
     */
    void deleteCode(Code input);

    /**
     * <pre>
     * 공통코드 등록
     * </pre>
     */
    void insertCode(Code input);
}
