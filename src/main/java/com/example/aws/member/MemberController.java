package com.example.aws.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Log4j2
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberEntity> create(@RequestBody MemberDTO memberDTO){
        log.info(memberDTO);
        return ResponseEntity.ok(memberService.create(memberDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberEntity> read(@PathVariable Long id){
        return ResponseEntity.ok(memberService.read(id));
    }

    @GetMapping
    public ResponseEntity<List<MemberEntity>> readAll(){
        return ResponseEntity.ok(memberService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberEntity> update(@PathVariable Long id,@RequestBody MemberDTO memberDTO){
        return ResponseEntity.ok(memberService.update(id,memberDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        memberService.delete(id);
    }

}
