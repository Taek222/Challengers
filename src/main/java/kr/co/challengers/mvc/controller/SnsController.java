package kr.co.challengers.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.co.challengers.mvc.domain.User;
import kr.co.challengers.mvc.service.SnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SNS")
@Api(tags = "SNS Api")
public class SnsController {

    @Autowired
    private SnsService snsService;

    //사용자 목록
    @GetMapping
    @ApiOperation(value="목록조회", notes="사용자 목록을 조회할 수 있습니다.")
    public List<User> getList(){
        return null;//snsService.getList();
    }

    //사용자 상세정보
    @GetMapping("/{userId}")
    @ApiOperation(value="상세 조회", notes="사용자 상세정보를 조회할 수 있습니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value="사용자ID", example = "testID")
    })
    public User get(@PathVariable String userId){
        return null;//snsService.get(userId);
    }

    //사용자 정보 등록/수정 저장
    @PutMapping("/save")
    @ApiOperation(value="저장", notes="사용자 상세정보를 저장할 수 있습니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value="사용자ID", example = "testID"),
            @ApiImplicitParam(name = "userNm", value="사용자 이름", example = "박이름"),
            @ApiImplicitParam(name = "cell", value="사용자 연락처", example = "010-0000-0000")
    })
    public void save(User user){
        //snsService.save(user);
    }

    //사용자 정보 삭제
    @GetMapping("/delete")
    public void delete(String userId){
        //snsService.delete(userId);
    }
}
