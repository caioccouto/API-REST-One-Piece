package onepiece.api1.piratas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PirataRepository extends JpaRepository<Pirata, Long> {
    Page<Pirata> findAllByAtivoTrue(Pageable pageable);
}
