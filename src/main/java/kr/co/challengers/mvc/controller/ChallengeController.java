package kr.co.challengers.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.co.challengers.configuration.exception.BaseException;
import kr.co.challengers.configuration.http.BaseResponse;
import kr.co.challengers.configuration.http.BaseResponseCode;
import kr.co.challengers.mvc.domain.Challenge;
import kr.co.challengers.mvc.domain.ChallengePhoto;
import kr.co.challengers.mvc.domain.Part;
import kr.co.challengers.mvc.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/challenge")
@Api(tags="Challenge Api")
public class ChallengeController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ChallengeService ChallengeService;

    //챌린지 등록 페이지
    @RequestMapping("/insertChallenge")
    public String insertChallenge() {
        return "challenge/insert";

    }

    //챌린지 목록 조회
    @GetMapping("/challengeList")
    @ApiOperation(value="목록조회", notes="챌린지 목록을 조회할 수 있습니다.")
    public BaseResponse<List<Challenge>> getChallengeList(){
        return new BaseResponse<List<Challenge>>(ChallengeService.getList());
    }


    //챌린지 썸네일 목록
    @GetMapping("/photoList")
    @ApiOperation(value="썸네일목록", notes="썸네일 목록을 조회할 수 있습니다.")
    public BaseResponse<List<ChallengePhoto>> photoList(){
        return new BaseResponse<List<ChallengePhoto>>(ChallengeService.getPhotoList());
    }

    //챌린지 상세 사진
    @GetMapping("/{challengeNo}")
    @ApiOperation(value="상세 사진 조회",notes="챌린지 상세사진정보를 조회할 수 있습니다")
    public BaseResponse<List<ChallengePhoto>> getChallengePhoto(@PathVariable int challengeNo){

        Map<String, Object> param = new HashMap<>();
        param.put("challengeNo",challengeNo);
        List<ChallengePhoto> photo = ChallengeService.getChallengePhoto(param);
        if(photo.isEmpty()){
            throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[]{"챌린지 사진"});
        }
        return new BaseResponse<List<ChallengePhoto>>(ChallengeService.getChallengePhoto(param));

    }

    //챌린지 상세 조회
    @GetMapping("/{challengeNo}")
    @ApiOperation(value="챌린지 상세 조회",notes="챌린지 상세정보를 조회할 수 있습니다")
    public BaseResponse<Challenge>  getChallenge(@PathVariable int challengeNo){
        Map<String, Object> param = new HashMap<>();
        param.put("challengeNo",challengeNo);
        Challenge challenge = ChallengeService.getChallenge(param);
        if(challenge == null){
            throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[]{"챌린지"});
        }
        return new BaseResponse<Challenge>(ChallengeService.getChallenge(param));
    }


    //배팅 상세
    @GetMapping("/{challengeNo")
    @ApiOperation(value="배팅 상세 조회 ", notes="배팅 상세 정보를 조회할 수 있습니다")
    public BaseResponse<Part> getPart(@PathVariable int challengeNo){
         Map<String, Object> param = new HashMap<>();
         param.put("challengeNo", challengeNo);
         Part part = ChallengeService.getPart(param);
         if(part ==  null){
             throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[]{"배팅"});
         }
         return new BaseResponse<Part>(ChallengeService.getPart(param));


    }


    //챌린지 등록
    @PutMapping("/insertEnd")
    @ApiOperation(value = "챌린지 등록", notes = "챌린지를 등록할 수 있습니다")
    public BaseResponse<String> insertEnd(Challenge challenge) {

        if(StringUtils.isEmpty(challenge.getTitle())){
            throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[]{"title","챌린지 제목"});
        }
        ChallengeService.insertChallenge(challenge);
        return new BaseResponse<String>(challenge.getTitle());

        //파일 업로드처리하기
//        String path = session.getServletContext().getRealPath("/resources/upload/challenge");
//        File dir = new File(path);
//        if (!dir.exists()) dir.mkdirs();
//        List<ChallengePhoto> files = new ArrayList();

        //썸네일
        //리네임드규칙 정하기
//        if (!upFile.isEmpty()) {
//            String originalFileName = upFile.getOriginalFilename();
//            String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
//
//            //중복되지않는 이름 설정
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
//            int rnd = (int) (Math.random() * 10000) + 1;
//            String renameFile = sdf.format(System.currentTimeMillis()) + "_" + rnd + ext;
//            //파일 업로드하기
//
//            try {
//                upFile.transferTo(new File(path + renameFile));
//                files.add(
//                        ChallengePhoto.builder().mainYn("Y")
//                                .photoName(renameFile)
//                                .build());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
            //일반사진
            //리네임규칙
//            if (!upFile2.isEmpty()) {
//                String originalFileName2 = upFile2.getOriginalFilename();
//                String ext2 = originalFileName2.substring(originalFileName2.lastIndexOf("."));
//
//                //중복되지않는 이름 설정
//                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
//                int rnd2 = (int) (Math.random() * 10000) + 1;
//                String renameFile2 = sdf2.format(System.currentTimeMillis()) + "_" + rnd2 + ext2;
//                //파일 업로드하기
//
//                try {
//                    upFile2.transferTo(new File(path + renameFile2));
//                    files.add(
//                            ChallengePhoto.builder().mainYn("Y")
//                                    .photoName(renameFile2)
//                                    .build());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }




            //int result = ChallengeService.insertChallenge(c);

        }

    }

