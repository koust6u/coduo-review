package coduo.reviewnotificator.web.api;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coduo.reviewnotificator.service.ThreadService;
import coduo.reviewnotificator.service.dto.ThreadReadResponse;
import coduo.reviewnotificator.web.dto.ThreadCreateWebRequest;
import coduo.reviewnotificator.web.dto.ThreadReadWebRequest;
import coduo.reviewnotificator.web.dto.ThreadReadWebResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/github")
@RequiredArgsConstructor
public class ThreadController {
    private final ThreadService threadService;

    @PostMapping("/thread")
    public ResponseEntity<Void> save(@Valid @RequestBody ThreadCreateWebRequest request) {
        threadService.createThreadCommand(request.toServiceRequest());

        return ResponseEntity.ok()
                .build();
    }

    @GetMapping("/thread")
    public ResponseEntity<ThreadReadWebResponse> search(
            @Valid @RequestHeader(name = "GITHUB_URL") ThreadReadWebRequest request) {
        ThreadReadResponse response = threadService.readThreadQuery(request.toServiceRequest());

        return ResponseEntity.ok(new ThreadReadWebResponse(response.ts(), response.url()));
    }
}
