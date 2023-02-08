package kr.co.challengers.mvc.service;

import kr.co.challengers.mvc.domain.Challenge;
import kr.co.challengers.mvc.domain.ChallengePhoto;
import kr.co.challengers.mvc.domain.Part;
import kr.co.challengers.mvc.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ChallengeService {
    @Autowired
    private ChallengeRepository challengeRepository;


    //챌린지 목록
    public List<Challenge> getList(){
        return challengeRepository.getList();
    }


    //챌린지 썸네일 목록
    public List<ChallengePhoto> getPhotoList(){
        return challengeRepository.getPhotoList();
    }


    //챌린지 상세사진 조회
    public List<ChallengePhoto> getChallengePhoto(Map<String,Object>param){
        return challengeRepository.getChallengePhoto(param);
    }
    //챌린지 상세 조회
    public Challenge getChallenge(Map<String, Object> param){
        return challengeRepository.getChallenge(param);
    }


    //배팅 상세 조회
    public Part getPart(Map<String, Object> param) {return challengeRepository.getPart(param);
    }
    public int insertChallenge(Challenge c){
       return challengeRepository.insertChallenge(c);
        }




}
