package courses.dao;

import courses.domain.entity.UserEntity;
import courses.domain.entity.UserTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    List<UserEntity> findByType(UserTypeEntity userTypeEntity);

    @Override
    void delete(UserEntity user);
}