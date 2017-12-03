package courses.service;

import courses.domain.dto.CourseDTO;
import courses.domain.entity.CourseEntity;
import courses.validation.exception.InvalidCourseProperty;

public interface CourseService {
    CourseEntity saveCourse(CourseDTO courseDTO) throws InvalidCourseProperty;
    CourseEntity updateCourse(CourseEntity course, CourseDTO courseDTO) throws InvalidCourseProperty;
}
