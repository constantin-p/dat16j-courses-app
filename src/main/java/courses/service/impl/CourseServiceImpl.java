package courses.service.impl;

import courses.dao.CourseRepository;
import courses.dao.ProgrammeRepository;
import courses.dao.UserRepository;
import courses.domain.dto.CourseDTO;
import courses.domain.entity.CourseEntity;
import courses.domain.entity.ProgrammeEntity;
import courses.domain.entity.UserEntity;
import courses.service.CourseService;
import courses.validation.exception.InvalidCourseProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ProgrammeRepository programmeRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CourseEntity saveCourse(CourseDTO courseDTO) throws InvalidCourseProperty {
        final CourseEntity course = new CourseEntity();

        course.setNameDA(courseDTO.getNameDA());
        course.setNameEN(courseDTO.getNameEN());

        course.setMandatory(courseDTO.isMandatory());
        course.setEctsPoints(courseDTO.getEctsPoints());
        course.setLanguage(courseDTO.getLanguage());
        course.setMinStudents(courseDTO.getMinStudents());
        course.setExpStudents(courseDTO.getExpStudents());
        course.setMaxStudents(courseDTO.getMaxStudents());
        course.setPrerequisites(courseDTO.getPrerequisites());
        course.setContent(courseDTO.getContent());
        course.setOutcome(courseDTO.getOutcome());
        course.setActivities(courseDTO.getActivities());
        course.setExamForm(courseDTO.getExamForm());


        course.setProgrammes(this.getProgrammes(courseDTO.getProgrammes()));
        course.setTeachers(this.getTeachers(courseDTO.getTeachers()));
        course.setStudents(this.getStudents(courseDTO.getStudents()));

        return courseRepository.save(course);
    }

    @Override
    public CourseEntity updateCourse(CourseEntity course, CourseDTO courseDTO) throws InvalidCourseProperty {

        course.setNameDA(courseDTO.getNameDA());
        course.setNameEN(courseDTO.getNameEN());

        course.setMandatory(courseDTO.isMandatory());
        course.setEctsPoints(courseDTO.getEctsPoints());
        course.setLanguage(courseDTO.getLanguage());
        course.setMinStudents(courseDTO.getMinStudents());
        course.setExpStudents(courseDTO.getExpStudents());
        course.setMaxStudents(courseDTO.getMaxStudents());
        course.setPrerequisites(courseDTO.getPrerequisites());
        course.setContent(courseDTO.getContent());
        course.setOutcome(courseDTO.getOutcome());
        course.setActivities(courseDTO.getActivities());
        course.setExamForm(courseDTO.getExamForm());


        course.setProgrammes(this.getProgrammes(courseDTO.getProgrammes()));
        course.setTeachers(this.getTeachers(courseDTO.getTeachers()));
        course.setStudents(this.getStudents(courseDTO.getStudents()));

        return courseRepository.save(course);
    }

    // Helpers
    private List<ProgrammeEntity> getProgrammes(List<Long> IDList) throws InvalidCourseProperty {
        List<ProgrammeEntity> programmes = new ArrayList<>();
        for (Long programmeID: IDList) {
            ProgrammeEntity programme = programmeRepository.findOne(programmeID);
            if(programme == null) {
                throw new InvalidCourseProperty("Invalid programmeID: " + programmeID);
            } else {
                programmes.add(programme);
            }
        }
        return programmes;
    }

    private List<UserEntity> getTeachers(List<Long> IDList) throws InvalidCourseProperty {
        List<UserEntity> teachers = new ArrayList<>();
        for (Long teacherID: IDList) {
            UserEntity teacher = userRepository.findOne(teacherID);
            if(teacher == null) {
                throw new InvalidCourseProperty("Invalid teacherID: " + teacherID);
            } else {
                teachers.add(teacher);
            }
        }
        return teachers;
    }

    private List<UserEntity> getStudents(List<Long> IDList) throws InvalidCourseProperty {
        List<UserEntity> students = new ArrayList<>();
        for (Long studentID: IDList) {
            UserEntity student = userRepository.findOne(studentID);
            if(student == null) {
                throw new InvalidCourseProperty("Invalid studentID: " + studentID);
            } else {
                students.add(student);
            }
        }
        return students;
    }
}
