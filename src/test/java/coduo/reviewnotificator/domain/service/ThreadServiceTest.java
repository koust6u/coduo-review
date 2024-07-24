package coduo.reviewnotificator.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import coduo.reviewnotificator.domain.Thread;
import coduo.reviewnotificator.domain.repository.ThreadRepository;
import coduo.reviewnotificator.service.ThreadService;
import coduo.reviewnotificator.service.dto.ThreadCreateRequest;
import coduo.reviewnotificator.service.dto.ThreadReadRequest;
import coduo.reviewnotificator.service.dto.ThreadReadResponse;

@Transactional
@SpringBootTest
class ThreadServiceTest {

    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private ThreadService sut;

    @Test
    @DisplayName("쓰레드 정보를 저장한다,")
    void save_thread_information() {
        // given
        ThreadCreateRequest request = new ThreadCreateRequest("ts", "url");

        // when
        sut.createThreadCommand(request);

        // then
        assertThat(threadRepository.findAll())
                .hasSize(1);
    }

    @Test
    @DisplayName("쓰레드 정보를 url기준으로 조회한다.")
    void search_thread_information_by_url() {
        // given
        String url = "url";
        String ts = "ts";
        threadRepository.save(new Thread(ts, url));
        ThreadReadRequest request = new ThreadReadRequest(url);

        // when
        ThreadReadResponse response = sut.readThreadQuery(request);

        // then
        assertThat(response.ts())
                .isSameAs(ts);
    }
}
