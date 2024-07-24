package coduo.reviewnotificator.service;

import org.springframework.stereotype.Service;

import coduo.reviewnotificator.domain.Thread;
import coduo.reviewnotificator.domain.repository.ThreadRepository;
import coduo.reviewnotificator.service.dto.ThreadCreateRequest;
import coduo.reviewnotificator.service.dto.ThreadReadRequest;
import coduo.reviewnotificator.service.dto.ThreadReadResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ThreadService {
    private final ThreadRepository threadRepository;

    public void createThreadCommand(ThreadCreateRequest request) {
        threadRepository.save(new Thread(request.ts(), request.url()));
    }

    public ThreadReadResponse readThreadQuery(ThreadReadRequest request) {
        Thread thread = threadRepository.findByUrl(request.url())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 영속성입니다."));

        return new ThreadReadResponse(thread.getTimestamp(), thread.getUrl());
    }
}
