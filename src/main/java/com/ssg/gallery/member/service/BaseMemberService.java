package com.ssg.gallery.member.service;

import com.ssg.gallery.member.entity.Member;
import com.ssg.gallery.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BaseMemberService implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void save(String name, String loginId, String loginPw) {
         memberRepository.save(new Member(name, loginId, loginPw));
    }
    //회원데이터 조회
    @Override
    public Member find(String loginId, String loginPw) {
        Optional<Member> member = memberRepository.findByLoginIdAndLoginPw(loginId,loginPw);
        return member.orElse(null);
    }
}
