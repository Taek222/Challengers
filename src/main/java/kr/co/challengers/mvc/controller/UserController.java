package kr.co.challengers.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.co.challengers.configuration.exception.BaseException;
import kr.co.challengers.configuration.http.BaseResponse;
import kr.co.challengers.configuration.http.BaseResponseCode;
import kr.co.challengers.mvc.domain.User;
import kr.co.challengers.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@Api(tags = "사용자API")
public class UserController {

    @Autowired
    private UserService userService;

    //사용자 목록
    @GetMapping
    @ApiOperation(value="목록조회", notes="사용자 목록을 조회할 수 있습니다.")
    public BaseResponse<List<User>> getList(){
        return new BaseResponse<List<User>>(userService.getList());
        //BaseResponse<리턴타입>(리턴할 데이터) 로 사용하면 미리 정의해둔 응답포맷에 맞게 리턴할 수 있다.
        //응답코드, 응답메시지, 데이터 로 구성된 json 형식으로 반환
    }

    //사용자 상세정보
    @GetMapping("/{userId}")
    @ApiOperation(value="상세 조회", notes="사용자 상세정보를 조회할 수 있습니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value="사용자ID", example = "testID")
    })
    public BaseResponse<User> get(@PathVariable String userId){
        User user = userService.get(userId);
        if(user == null){
            throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[]{"사용자"});
            //예외처리와 예외코드는 BaseResponseCode, message_ko.properties 에 추가 또는 코드 찾아서 사용
            //예외처리시 BaseException(예외코드) 또는 BaseException(예외코드, {메시지에 포함시킬 용어1, 메시지에 포함시킬 용어2 ...}) 형식으로 처리한다.
        }
        return new BaseResponse<User>(userService.get(userId));
    }

    //사용자 정보 등록/수정 저장
    @PutMapping("/save")
    @ApiOperation(value="저장", notes="사용자 상세정보를 저장할 수 있습니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value="사용자ID", example = "testID"),
            @ApiImplicitParam(name = "userNm", value="사용자 이름", example = "박이름"),
            @ApiImplicitParam(name = "cell", value="사용자 연락처", example = "010-0000-0000")
    })
    public BaseResponse<String> save(User user){
        if(StringUtils.isEmpty(user.getUserId())){
            throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[]{"userId", "사용자 아이디"});
        }
        userService.save(user);
        return new BaseResponse<String>(user.getUserId());
    }

    //사용자 정보 삭제
    @GetMapping("/delete")
    public BaseResponse<Boolean> delete(String userId){
        User user = userService.get(userId);
        if(user == null){
            throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[]{"사용자"});
        }
        userService.delete(userId);
        return new BaseResponse<Boolean>(true);
    }
}
