package coduo.reviewnotificator.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MemberManager {
    private static final Map<String, List<String>> members;
    private static final String BACK_END = "back_end";
    private static final String FRONT_END = "front_end";

    static {
        List<String> front = List.of("dle234", "anttiey", "greetings1012");
        List<String> back = List.of("koust6u", "reddevilmidzy", "yechop", "kelly6bf", "JiHyeonL");
        members = new HashMap<>();
        members.put(FRONT_END, front);
        members.put(BACK_END, back);
    }

    public List<String> getMembersWithout(String githubId) {
        return members.values()
                .stream()
                .filter(list -> list.contains(githubId))
                .flatMap(Collection::stream)
                .filter(id -> !id.equals(githubId))
                .toList();
    }
}
