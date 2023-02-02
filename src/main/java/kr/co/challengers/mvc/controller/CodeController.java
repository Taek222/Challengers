package kr.co.challengers.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.co.challengers.configuration.http.BaseResponse;
import kr.co.challengers.mvc.domain.Code;
import kr.co.challengers.mvc.service.CodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/code")
@Api(tags = "공통코드 API")
public class CodeController {

    private CodeService codeService;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping
    @ApiOperation(value = "그룹코드 목록 조회")
    public BaseResponse<List<Code>> getGroupCodeList() {

        List<Code> groupCodeList = codeService.getGroupCodeList();

        return new BaseResponse<List<Code>>(groupCodeList);
    }

    @GetMapping("/{comGrpCd}")
    @ApiOperation(value = "공통코드 목록 조회")
    public BaseResponse<List<Code>> getCodeList(@PathVariable String comGrpCd) {

        List<Code> codeList = codeService.getCodeList(Code.builder().comGrpCd(comGrpCd).build());

        return new BaseResponse<List<Code>>(codeList);
    }

    // TODO : 공통코드 비활성화

    // TODO : 공통코드 삭제
}
