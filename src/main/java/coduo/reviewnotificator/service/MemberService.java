package coduo.reviewnotificator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import coduo.reviewnotificator.domain.MemberManager;
import coduo.reviewnotificator.service.dto.MemberReadRequest;
import coduo.reviewnotificator.service.dto.MemberReadResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberManager memberManager;

    public List<MemberReadResponse> getMemberWithSpecific(MemberReadRequest request) {
        return memberManager.getMembersWithout(request.githubId())
                .stream()
                .map(MemberReadResponse::new)
                .toList();
    }
}
