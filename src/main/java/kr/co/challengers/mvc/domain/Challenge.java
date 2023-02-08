package kr.co.challengers.mvc.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Challenge {

    private int challengeNo;
    private String title;
    private String contents;
    private Date periodStart;
    private String frequency;
    private String example;
    private String category;
    private String type;
    private String mainExp;
    private String status;




}
