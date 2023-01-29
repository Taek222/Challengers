package kr.co.challengers.mvc.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChallengePhoto {

    private int photoNo;
    private int challengeNo;
    private String mainYn;
    private String photoName;
}
