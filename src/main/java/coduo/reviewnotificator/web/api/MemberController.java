package coduo.reviewnotificator.web.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coduo.reviewnotificator.service.MemberService;
import coduo.reviewnotificator.web.dto.MemberReadWebRequest;
import coduo.reviewnotificator.web.dto.MemberReadWebResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<MemberReadWebResponse>> getMemberWith(@RequestHeader(name = "GITHUB_ID")
                                                                     MemberReadWebRequest request) {

        List<MemberReadWebResponse> responses = memberService.getMemberWithSpecific(request.toServiceRequest())
                .stream()
                .map(serviceResponse -> new MemberReadWebResponse(serviceResponse.githubId()))
                .toList();

        return ResponseEntity.ok(responses);
    }
}
