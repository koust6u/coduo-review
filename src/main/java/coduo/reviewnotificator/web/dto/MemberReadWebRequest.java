package coduo.reviewnotificator.web.dto;

import coduo.reviewnotificator.service.dto.MemberReadRequest;

public record MemberReadWebRequest(String githubId) {

    public MemberReadRequest toServiceRequest() {
        return new MemberReadRequest(githubId);
    }
}
