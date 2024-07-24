package coduo.reviewnotificator.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import coduo.reviewnotificator.domain.Thread;

public interface ThreadRepository extends JpaRepository<Thread, Long> {

    Optional<Thread> findByUrl(String url);
}
