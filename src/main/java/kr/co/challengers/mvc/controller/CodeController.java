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
@RequestMapping("/CODE")
@Api(tags = "CODE Api")
public class CodeController {

    private CodeService codeService;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping(value = {"/list/{comGrpCd}", "/list"})
    @ApiOperation(value="목록 조회", notes="공통 코드 목록을 조회한다.")
    public BaseResponse<List<Code>> getCodeList(@PathVariable(required = false) String comGrpCd) {

        return new BaseResponse<List<Code>>(codeService.getCodeList(comGrpCd));
    }
}
