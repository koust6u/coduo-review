package coduo.reviewnotificator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReviewnotificatorApplicationTests {

    @Test
    void contextLoads() {
        assertThatCode(() -> ReviewnotificatorApplication.main(new String[]{}))
                .doesNotThrowAnyException();
    }

}
