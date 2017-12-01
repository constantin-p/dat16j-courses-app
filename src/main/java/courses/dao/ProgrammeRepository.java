package courses.dao;

import courses.domain.entity.ProgrammeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammeRepository extends JpaRepository<ProgrammeEntity, Long> {
}
