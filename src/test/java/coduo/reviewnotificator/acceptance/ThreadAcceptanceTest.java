package coduo.reviewnotificator.acceptance;

import static org.hamcrest.Matchers.is;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

class ThreadAcceptanceTest extends AcceptanceFixture {

    @Test
    @DisplayName("쓰레드 정보 저장 요청")
    void thread_save_request() {
        // given
        Map<String, String> request = Map.of(
                "ts", "some time stamp",
                "url", "some url"
        );

        // when & then
        RestAssured
                .given()
                .body(request)
                .contentType(ContentType.JSON)

                .when()
                .post("/github/thread")

                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("쓰레드 정보를 URL 기준으로 조회한다.")
    void search_thread_information_by_url() {
        // given
        String url = "some url";
        String timeStamp = "timeStamp";
        create_thread(timeStamp, url);

        // when & then
        RestAssured
                .given()
                .header("GITHUB_URL", url)

                .when()
                .get("/github/thread")

                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .body("ts", is(timeStamp))
                .body("url", is(url));
    }


    void create_thread(String ts, String url) {
        Map<String, String> request = Map.of("ts", ts, "url", url);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(request)

                .when()
                .post("/github/thread");
    }
}
