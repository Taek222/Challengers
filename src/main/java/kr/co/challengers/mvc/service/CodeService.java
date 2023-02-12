package kr.co.challengers.mvc.service;

import kr.co.challengers.mvc.domain.Code;
import kr.co.challengers.mvc.repository.CodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 공통코드 관리 Service
 */
@Service
public class CodeService {

    private CodeRepository codeRepository;

    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    /**
     * <pre>
     * 그룹코드 목록 조회
     * </pre>
     *
     * @return 그룹 코드 목록
     */
    public List<Code> getGroupCodeList() {
        return codeRepository.getGroupCodeList();
    }

    /**
     * <pre>
     * 공통코드 목록 조회
     * </pre>
     *
     * @param input 그룹코드 조회 조건 (예: 그룹코드, 사용여부 등)
     * @return 조회 조건에 해당하는 공통 코드 목록
     */
    public List<Code> getCodeList(Code input) {
        return codeRepository.getCodeList(input);
    }

    /**
     * <pre>
     * 공통코드 사용여부 변경
     * </pre>
     *
     * @param input comGrpCd 그룹코드
     *              comCd 공통코드(그룹코드일 경우 'ZZ')
     *              useYn 활성화/비활성화 여부
     */
    public void updateCodeUseYn(Code input) {
        codeRepository.updateCodeUseYn(input);
    }

    /**
     * <pre>
     * 공통코드 삭제
     * </pre>
     *
     * @param input comGrpCd 그룹코드
     *              comCd 공통코드(그룹코드일 경우 null)
     *              useYn 활성화/비활성화 여부
     */
    public void deleteCode(Code input) {
        codeRepository.deleteCode(input);
    }

    /**
     * <pre>
     * 공통코드 등록
     * </pre>
     */
    public void insertCode(Code input) {
        codeRepository.insertCode(input);
    }
}
