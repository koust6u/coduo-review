package coduo.reviewnotificator.web.dto;

import jakarta.validation.constraints.NotBlank;

import coduo.reviewnotificator.service.dto.ThreadReadRequest;

public record ThreadReadWebRequest(@NotBlank(message = "URL이 비어있습니다.") String url) {

    public ThreadReadRequest toServiceRequest() {
        return new ThreadReadRequest(url);
    }
}
