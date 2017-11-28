package courses.dao;

import courses.domain.entity.UserTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserTypeEntity, Long> {
    UserTypeEntity findByName(String name);
}