package courses.service.impl;

import courses.dao.CourseRepository;
import courses.dao.ProgrammeRepository;
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
        course.setOutcome(courseDTO.getOutcome());
        course.setActivities(courseDTO.getActivities());
        course.setExamForm(courseDTO.getExamForm());


        course.setProgrammes(this.getProgrammes(courseDTO.getProgrammes()));
        //course.setTeachers(courseDTO.getTeachers());
        //course.setStudents(courseDTO.getStudents());

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
}
