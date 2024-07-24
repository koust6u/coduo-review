package coduo.reviewnotificator.web.dto;

import jakarta.validation.constraints.NotBlank;

import coduo.reviewnotificator.service.dto.ThreadCreateRequest;

public record ThreadCreateWebRequest(@NotBlank(message = "타임스탬프 값이 비어있습니다.") String ts,
                                     @NotBlank(message = "URL 값이 비어있습니다.") String url) {

    public ThreadCreateRequest toServiceRequest() {
        return new ThreadCreateRequest(ts, url);
    }
}
