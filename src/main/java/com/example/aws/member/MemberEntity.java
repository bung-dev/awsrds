package com.example.aws.member;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Getter
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
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
