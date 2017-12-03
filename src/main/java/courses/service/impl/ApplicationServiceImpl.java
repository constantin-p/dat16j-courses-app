package courses.service.impl;

import courses.dao.ApplicationRepository;
import courses.dao.CourseRepository;
import courses.domain.entity.ApplicationEntity;
import courses.domain.entity.CourseEntity;
import courses.domain.entity.UserEntity;
import courses.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public ApplicationEntity saveApplication(UserEntity userEntity, CourseEntity courseEntity) {
        final ApplicationEntity applicationEntity = new ApplicationEntity();

        applicationEntity.setStudent(userEntity);
        applicationEntity.setCourse(courseEntity);
        applicationEntity.setCreatedAt(LocalDateTime.now());

        return applicationRepository.save(applicationEntity);
    }

    @Override
    public ApplicationEntity acceptApplication(ApplicationEntity applicationEntity) {
        CourseEntity courseEntity = applicationEntity.getCourse();
        courseEntity.addStudent(applicationEntity.getStudent());

        courseRepository.save(courseEntity);
        applicationEntity.setActive(false);
        return applicationRepository.save(applicationEntity);
    }

    @Override
    public ApplicationEntity rejectApplication(ApplicationEntity applicationEntity) {
        applicationEntity.setRejected(true);
        applicationEntity.setActive(false);
        return applicationRepository.save(applicationEntity);
    }
}
