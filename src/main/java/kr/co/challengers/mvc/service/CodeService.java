package kr.co.challengers.mvc.service;

import kr.co.challengers.mvc.domain.Code;
import kr.co.challengers.mvc.repository.CodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeService {

    private CodeRepository codeRepository;

    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    /**
     * <pre>
     * 공통 코드 목록 조회
     * </pre>
     *
     * @param input 그룹코드 조회 조건 (예: 그룹코드, 사용여부 등)
     * @return 조회 조건에 해당하는 공통 코드 목록
     */
    public List<Code> getCodeList(Code input) {
        return codeRepository.getCodeList(input);
    }
}
