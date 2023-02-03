package kr.co.challengers.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.co.challengers.configuration.http.BaseResponse;
import kr.co.challengers.configuration.session.HttpSessionUser;
import kr.co.challengers.mvc.domain.Code;
import kr.co.challengers.mvc.service.CodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/code")
@Api(tags = "공통코드 API")
public class CodeController {

    private final HttpSessionUser httpSessionUser;
    private CodeService codeService;

    public CodeController(HttpSessionUser httpSessionUser, CodeService codeService) {
        this.httpSessionUser = httpSessionUser;
        this.codeService = codeService;
    }

    @GetMapping
    @ApiOperation(value = "그룹코드 목록 조회")
    public BaseResponse<List<Code>> getGroupCodeList() {

        List<Code> groupCodeList = codeService.getGroupCodeList();

        return BaseResponse.SuccessfulResult(groupCodeList);
    }

    @GetMapping("/{comGrpCd}")
    @ApiOperation(value = "공통코드 목록 조회")
    public BaseResponse<List<Code>> getCodeList(@PathVariable String comGrpCd) {

        List<Code> codeList = codeService.getCodeList(Code.builder().comGrpCd(comGrpCd).build());

        return BaseResponse.SuccessfulResult(codeList);
    }

    @PostMapping("/{comGrpCd}/update")
    @ApiOperation(value = "공통코드 사용여부 변경")
    public BaseResponse<Boolean> updateCodeUseYn(@PathVariable String comGrpCd,
                                                 @RequestParam String comCd,
                                                 @RequestParam String useYn) {

        String userId = httpSessionUser.getAttribute().getUserId();

        Code input = Code.builder()
                .comGrpCd(comGrpCd)
                .comCd(comCd)
                .useYn(useYn)
                .modUser(userId).build();

        codeService.updateCodeUseYn(input);

        return BaseResponse.SuccessfulResult(true);
    }

    @PostMapping("/{comGrpCd}/delete")
    @ApiOperation(value = "공통코드 삭제")
    public BaseResponse<Boolean> deleteCode(@PathVariable String comGrpCd,
                                            @RequestParam(required = false) String comCd) {

        String userId = httpSessionUser.getAttribute().getUserId();

        Code input = Code.builder()
                .comGrpCd(comGrpCd)
                .comCd(comCd)
                .modUser(userId).build();

        codeService.deleteCode(input);

        return BaseResponse.SuccessfulResult(true);
    }
}
