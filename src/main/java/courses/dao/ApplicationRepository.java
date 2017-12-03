package courses.dao;

import courses.domain.entity.ApplicationEntity;
import courses.domain.entity.CourseEntity;
import courses.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {
    List<ApplicationEntity> findByStudent(UserEntity userEntity);
    List<ApplicationEntity> findByCourse(CourseEntity courseEntity);
}
