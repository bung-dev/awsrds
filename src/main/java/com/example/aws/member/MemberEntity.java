package com.example.aws.member;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.ToString;

@Entity
@ToString
@Table(name = "member")
@Builder
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String userPwd;

    public void changeUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public void changeUserName(String userName) {
        this.userName = userName;
    }
}
