package com.example.aws.member;

import lombok.Getter;


@Getter
public class MemberDTO {

    private String userName;

    private String userPwd;

    //dto -> entity
    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .userName(userName)
                .userPwd(userPwd)
                .build();
    }
}
