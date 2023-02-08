package kr.co.challengers.mvc.repository;

import kr.co.challengers.mvc.domain.Challenge;
import kr.co.challengers.mvc.domain.ChallengePhoto;
import kr.co.challengers.mvc.domain.Part;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ChallengeRepository {
    int insertChallenge(Challenge c);
    int insertChallengePhoto(ChallengePhoto cp);

    //챌린지 목록
    List<Challenge> getList();

    //챌린지 썸네일 목록
    List<ChallengePhoto> getPhotoList();

    //챌린지 상세사진조회
    List<ChallengePhoto> getChallengePhoto(Map<String, Object> param);


    //챌린지 상세조회
    Challenge getChallenge(Map<String, Object> param);

    //배팅 상세조회
    Part getPart(Map<String, Object> param);
}
