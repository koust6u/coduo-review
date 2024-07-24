package coduo.reviewnotificator.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ThreadTest {

    @Test
    @DisplayName("쓰레드에 대한 영속성 엔티티를 생성한다")
    void generate_thread_persistence_entity() {
        // given
        String validTimestamp = "timestamp";
        String validUrl = "http://github.com";

        // when & then
        assertThatCode(() -> new Thread(validTimestamp, validUrl))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("타임 스탬프에 빈값이 오면 예외를 발생시킨다.")
    void throw_exception_when_timestamp_is_blank() {
        // given
        String blankTimeStamp = "";
        String notBlankUrl = "some url";

        // when & then
        assertThatThrownBy(() -> new Thread(blankTimeStamp, notBlankUrl))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("URL에 빈값이 오면 예외를 발생시킨다.")
    void throw_exception_when_url_is_blank() {
        // given
        String notBlankTimeStamp = "some timestamp";
        String blankUrl = "";

        // when & then
        assertThatThrownBy(() -> new Thread(notBlankTimeStamp, blankUrl))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
