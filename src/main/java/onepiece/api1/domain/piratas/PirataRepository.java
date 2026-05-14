package onepiece.api1.domain.piratas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PirataRepository extends JpaRepository<Pirata, Long> {
    Page<Pirata> findAllByAtivoTrue(Pageable pageable);
}
