package coduo.reviewnotificator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberManagerTest {

    @Test
    @DisplayName("특정 이름을 제외한 같은 스택 멤버들의 github ID를 반환한다")
    void return_specific_github_id_with_specific_stack() {
        // given
        String githubId = "koust6u";
        MemberManager sut = new MemberManager();

        // when
        List<String> membersWithout = sut.getMembersWithout(githubId);

        // then
        assertThat(membersWithout)
                .containsExactlyInAnyOrder("reddevilmidzy", "yechop", "kelly6bf", "JiHyeonL");
    }

}
