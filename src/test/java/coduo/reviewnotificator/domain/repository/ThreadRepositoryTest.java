package coduo.reviewnotificator.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import coduo.reviewnotificator.domain.Thread;

@DataJpaTest
class ThreadRepositoryTest {

    @Autowired
    private ThreadRepository sut;

    @Test
    @DisplayName("url을 기준으로 영속성을 조회한다")
    void search_persistence_by_url() {
        // given
        String url = "http://coduo.site";
        String timestamp = "some timestamp";
        Thread thread = new Thread(timestamp, url);
        sut.save(thread);

        // when
        Optional<Thread> persistence = sut.findByUrl(url);

        // then
        assertThat(persistence).isPresent();
    }

}
