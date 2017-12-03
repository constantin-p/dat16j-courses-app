package courses.service;

import courses.domain.entity.ApplicationEntity;
import courses.domain.entity.CourseEntity;
import courses.domain.entity.UserEntity;

public interface ApplicationService {
    ApplicationEntity saveApplication(UserEntity userEntity, CourseEntity courseEntity);
}