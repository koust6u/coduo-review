package coduo.reviewnotificator.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "THREAD")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Thread {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "THREAD_TS", nullable = false, unique = true)
    private String timestamp;

    @Column(name = "HTML_URL", nullable = false, unique = true)
    private String url;

    public Thread(String timestamp, String url) {
        validate(timestamp, url);
        this.timestamp = timestamp;
        this.url = url;
    }

    private void validate(String timestamp, String url) {
        if (timestamp.isBlank() || url.isBlank()) {
            throw new IllegalArgumentException("빈값이 입력되었습니다.");
        }
    }
}
