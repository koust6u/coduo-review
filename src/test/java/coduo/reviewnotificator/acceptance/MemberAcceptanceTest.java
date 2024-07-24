package coduo.reviewnotificator.acceptance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;

class MemberAcceptanceTest extends AcceptanceFixture {

    @Test
    @DisplayName("특정 회원 제외 & 동일 스택의 크루들의 깃허브 아이디를 가져온다.")
    void get_crew_githubId_with_specific_stack_and_without_specific_name() {
        // given
        String githubId = "koust6u";

        // when & then
        RestAssured
                .given()
                .header("GITHUB_ID", githubId)

                .when()
                .get("/member")

                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
    }
}
