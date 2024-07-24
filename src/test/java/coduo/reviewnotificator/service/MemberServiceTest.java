package coduo.reviewnotificator.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import coduo.reviewnotificator.service.dto.MemberReadRequest;
import coduo.reviewnotificator.service.dto.MemberReadResponse;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("특정 회원을 제외한 동일 스택 모든 크루들을 조회한다.")
    void get_specific_member_without_specific_member() {
        // given
        String githubId = "dle234";
        MemberReadRequest request = new MemberReadRequest(githubId);

        // when
        List<MemberReadResponse> memberWithSpecific = memberService.getMemberWithSpecific(request);

        // then
        assertThat(memberWithSpecific)
                .hasSize(2)
                .extracting("githubId")
                .contains("anttiey", "greetings1012");
    }

}
