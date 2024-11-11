package com.example.aws.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    //멤버 생성
    public MemberEntity create(MemberDTO memberDTO){
        try {
            MemberEntity member = memberDTO.toEntity();
            return memberRepository.save(member);
        } catch (Exception e){
            throw new IllegalArgumentException("잘못된 정보를 입력하였습니다");
        }
    }

    //멤버 조회
    @Transactional(readOnly = true)
    public List<MemberEntity> readAll(){
        return memberRepository.findAll();
    }

    //멤버 상세 조회
    @Transactional(readOnly = true)
    public MemberEntity read(Long id){
        return memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    //멤버 수정
    public MemberEntity update(Long id,MemberDTO memberDTO){
        try{
            MemberEntity member = memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
            member.changeUserName(memberDTO.getUserName());
            member.changeUserPwd(memberDTO.getUserPwd());
            return memberRepository.save(member);
        } catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    //멤버 삭제
    public void delete(Long id){
        memberRepository.deleteById(id);
    }
}
