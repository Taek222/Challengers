package kr.co.challengers.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.co.challengers.configuration.exception.BaseException;
import kr.co.challengers.configuration.http.BaseResponse;
import kr.co.challengers.configuration.http.BaseResponseCode;
import kr.co.challengers.configuration.session.HttpSessionUser;
import kr.co.challengers.configuration.web.bind.annotation.RequestConfig;
import kr.co.challengers.mvc.domain.User;
import kr.co.challengers.mvc.service.UserService;
import kr.co.challengers.session.SessionUser;
import kr.co.challengers.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user")
@Api(tags = "사용자API")
public class UserController {

    private final HttpSessionUser httpSessionUser;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private FileUtils fileUtils;

    @GetMapping("/login/{userId}")
    @ResponseBody
    public boolean login(@PathVariable String userId){
        Map<String, Object> param = new HashMap<>();
        param.put("userId", userId);
        User loginTryUser = userService.login(param);

        if(loginTryUser !=null) {
            SessionUser session = new SessionUser();
            session.setUser(loginTryUser);
            //로그인 시 세션에 정보 저장
            httpSessionUser.setAttribute(session);
            return true;
        }else{
            throw new BaseException(BaseResponseCode.LOGIN_REQUIRED);
        }
    }

    @GetMapping("/mypage/info")
    public ModelAndView info(){
        ModelAndView mv = new ModelAndView();
        if(httpSessionUser.getAttribute()!=null) {
            mv.setViewName("/mypage/info");
            mv.addObject("pageNm", "mypage/info");
            mv.addObject("userInfo", httpSessionUser.getAttribute());
        }else{
            mv.setViewName("/login");
            mv.addObject("pageNm", "로그인화면");
            mv.addObject("message", "세션이 유효하지 않습니다.");
        }
        return mv;
    }

    @GetMapping("/logout")
    public ModelAndView logout(){
        ModelAndView mv = new ModelAndView();
        httpSessionUser.invalidate();
        mv.setViewName("/home");
        mv.addObject("pageNm", "홈 화면");
        mv.addObject("message", "정상 로그아웃 되었습니다.");
        return mv;
    }

    //사용자 목록
    @GetMapping
    @ApiOperation(value="목록조회", notes="사용자 목록을 조회할 수 있습니다.")
    public BaseResponse<List<User>> getList(){
        logger.info("UserController 의 getList");
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
        Map<String, Object> param = new HashMap<>();
        param.put("userId", userId);
        User user = userService.get(param);
        if(user == null){
            throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[]{"사용자"});
            //예외처리와 예외코드는 BaseResponseCode, message_ko.properties 에 추가 또는 코드 찾아서 사용
            //예외처리시 BaseException(예외코드) 또는 BaseException(예외코드, {메시지에 포함시킬 용어1, 메시지에 포함시킬 용어2 ...}) 형식으로 처리한다.
        }
        return new BaseResponse<User>(userService.get(param));
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
    @DeleteMapping("/delete/{userId}")
    @RequestConfig(loginCheck = true) //로그인 체크가 필수인 경우
    public BaseResponse<Boolean> delete(@PathVariable String userId){
        Map<String, Object> param = new HashMap<>();
        param.put("userId", userId);
        User user = userService.get(param);
        if(user == null){
            throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[]{"사용자"});
        }
        userService.delete(userId);
        return new BaseResponse<Boolean>(true);
    }

    @PostMapping("/filesave")
    public BaseResponse<Boolean> fileSave (@RequestParam("uploadFile")MultipartFile multipartFile){
        return fileUtils.uploadFiles(multipartFile);
    }
}
