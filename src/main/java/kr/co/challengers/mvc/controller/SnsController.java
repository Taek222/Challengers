package kr.co.challengers.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.co.challengers.configuration.exception.BaseException;
import kr.co.challengers.configuration.http.BaseResponse;
import kr.co.challengers.configuration.http.BaseResponseCode;
import kr.co.challengers.configuration.session.HttpSessionUser;
import kr.co.challengers.mvc.domain.Sns;
import kr.co.challengers.mvc.domain.ToDo;
import kr.co.challengers.mvc.mapper.SnsMapper;
import kr.co.challengers.mvc.parameter.SnsRequestParameter;
import kr.co.challengers.mvc.parameter.ToDoRequestParameter;
import kr.co.challengers.mvc.service.SnsService;
import kr.co.challengers.mvc.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/SNS")
@Api(tags = "SNS API")
public class SnsController {

    private final HttpSessionUser httpSessionUser;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SnsService snsService;

    @Autowired
    private ToDoService todoService;

    /*
    * [snsMain]
    * 친구 스토리 목록 조회
    */
    @GetMapping("/getFStoryList")
    @ApiOperation(value="스토리업로드한 친구목록", notes="[snsMain] 상단 스토리를 업로드한 친구 목록")
    public BaseResponse<List<Sns>> getFStoryList(){
        //SnsRequestParameter param = new SnsRequestParameter();
        if(httpSessionUser.getAttribute()!=null) {
            String sessionUserId = httpSessionUser.getAttribute().getUserId();
            List<Sns> dataset = null;/*snsService.getStoryFList(
                    SnsRequestParameter.builder()
                            .userId(sessionUserId)
                            .build());*/
            return BaseResponse.SuccessfulResult(dataset);
        }else{
            throw new BaseException(BaseResponseCode.LOGIN_REQUIRED);
        }
    }

    /*
     * [snsMain]
     * 나를 제외한 스토리 랜덤 조회(카테고리 다중선택)
     */
    @GetMapping("/getRandom")
    @ApiOperation(value="랜덤 스토리목록 조회", notes="[snsMain] 선택한 카테고리에 따라 스토리 랜덤 검색")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryList", value = "카테고리선택", example = "WORKOUT, HABITS, MENTAL")
    })
    public BaseResponse<List<Sns>> getRandomStory(@RequestParam("categoryList") List<String> categoryList){
//        SnsRequestParameter sns = new SnsRequestParameter();

        if(httpSessionUser.getAttribute()!=null) {
            String sessionUserId = httpSessionUser.getAttribute().getUserId();
//            param.setCategoryList(categoryList);
//            param.setUserId(httpSessionUser.getAttribute().getUserId());
            List<Sns> dataset = null;/*snsService.getRandomStory(
                    SnsRequestParameter.builder()
                            .userId(sessionUserId)
                            .categoryList(categoryList)
                            .build());*/
            return BaseResponse.SuccessfulResult(dataset);
        }else{
            throw new BaseException(BaseResponseCode.LOGIN_REQUIRED);
        }
    }

    /*
     * [regStory]
     * 오늘 완료한 to-do list 가져오기
     */
    @GetMapping("/getTodoList")
    @ApiOperation(value="완료한 to-do list 조회", notes="[regStory] 완료한 to-do list 조회 => 나중에 이미지로 만들어야함")
    public BaseResponse<List<ToDo>> getTodoList(){
        if(httpSessionUser.getAttribute()!=null) {
            String sessionUserId = httpSessionUser.getAttribute().getUserId();

            List<ToDo> dataset = todoService.getTodayToDo(
                    ToDoRequestParameter.builder()
                            .userId(sessionUserId)
                            .status("Y")
                            .build());
            return BaseResponse.SuccessfulResult(dataset);
        }else{
            throw new BaseException(BaseResponseCode.LOGIN_REQUIRED);
        }
    }

/*
/*

    @GetMapping("/getRandom")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categories", value="카테고리선택", example = "HEALTH")
    })
    public BaseResponse<List<Sns>> getRandomStory(SnsRequestParameter param){
        param.setUserId(httpSessionUser.getAttribute().getUserId());
        return new BaseResponse<List<Sns>>(snsService.getRandomStory(param));
    }


    */
/*
    regStory 화면 이동
     *//*

    @RequestMapping("/regStory")
    public ModelAndView regStoryPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/sns/regStory");
        mv.addObject("pageNm", "regStory");
        mv.addObject("title", "스토리등록");
        return mv;
    }

    */
/*
    storyLikeList 화면 이동
     *//*

    @RequestMapping("/storyLikeList")
    public ModelAndView storyLikeListPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/sns/storyLikeList");
        mv.addObject("pageNm", "storyLikeList");
        mv.addObject("title", "좋아요한 사용자의 목록");
        return mv;
    }

    */
/*
    myStory 화면 이동
     *//*

    @RequestMapping("/myStory")
    public ModelAndView myStoryPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/sns/myStory");
        mv.addObject("pageNm", "myStory");
        mv.addObject("title", "내 스토리 목록보기");
        return mv;
    }


*/

}