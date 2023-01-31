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
     * 공통코드 목록 조회
     * </pre>
     *
     * @return 공통코드 목록
     */
    public List<Code> getCodeList(String comGrpCd) {
        return codeRepository.getCodeList(Code.builder().comGrpCd(comGrpCd).build());
    }
}
