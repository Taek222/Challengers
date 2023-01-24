package kr.co.challengers.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.co.challengers.configuration.http.BaseResponse;
import kr.co.challengers.mvc.domain.Sns;
import kr.co.challengers.mvc.domain.User;
import kr.co.challengers.mvc.service.SnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/SNS")
@Api(tags = "SNS Api")
public class SnsController {

    @Autowired
    private SnsService snsService;

    /*
    SnsMain 화면 이동
    사용자의 스토리 및 친구 스토리 조회
    @Param : 사용자 ID(필수값)
     */
    public BaseResponse<List<Sns>> getStoryList(){
        return new BaseResponse<List<Sns>>(snsService.getStoryList());
    }

    /*
    SnsMain 스토리 랜덤 조회
    @Param : 태그(선택)
     */


    /*
    regStory 화면 이동
     */
    @RequestMapping("/regStory")
    public ModelAndView regStoryPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/sns/regStory");
        mv.addObject("pageNm", "regStory");
        mv.addObject("title", "스토리등록");
        return mv;
    }

    /*
    storyLikeList 화면 이동
     */
    @RequestMapping("/storyLikeList")
    public ModelAndView storyLikeListPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/sns/storyLikeList");
        mv.addObject("pageNm", "storyLikeList");
        mv.addObject("title", "좋아요한 사용자의 목록");
        return mv;
    }

    /*
    myStory 화면 이동
     */
    @RequestMapping("/myStory")
    public ModelAndView myStoryPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/sns/myStory");
        mv.addObject("pageNm", "myStory");
        mv.addObject("title", "내 스토리 목록보기");
        return mv;
    }

}