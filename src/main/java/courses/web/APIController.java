package courses.web;

import courses.dao.CourseRepository;
import courses.dao.ProgrammeRepository;
import courses.domain.dto.CourseDTO;
import courses.domain.dto.ProgrammeDTO;
import courses.domain.entity.CourseEntity;
import courses.domain.entity.ProgrammeEntity;
import courses.service.CourseService;
import courses.service.ProgrammeService;
import courses.service.UserService;
import courses.validation.exception.InvalidCourseProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api")
@RestController
public class APIController {

    @Autowired
    private ProgrammeService programmeService;

    @Autowired
    ProgrammeRepository programmeRepository;

    @Autowired
    CourseService courseService;

    @Autowired
    CourseRepository courseRepository;

    // Study Programmes
    @GetMapping("/programmes")
    public List<ProgrammeEntity> getAllProgrammes() {
        return programmeRepository.findAll();
    }

    @PostMapping("/programmes")
    public ProgrammeEntity createProgramme(@Valid @RequestBody ProgrammeDTO programmeDTO) {
        return programmeService.saveProgramme(programmeDTO);
    }

    @GetMapping("/programmes/{id}")
    public ResponseEntity<ProgrammeEntity> getProgrammeById(@PathVariable(value = "id") Long programmeID) {
        ProgrammeEntity programme = programmeRepository.findOne(programmeID);
        if(programme == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(programme);
    }

    // Courses
    @GetMapping("/courses")
    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    @PostMapping("/courses")
    public ResponseEntity<CourseEntity> createCourse(@Valid @RequestBody CourseDTO courseDTO) {
        try {
            return ResponseEntity.ok().body(courseService.saveCourse(courseDTO));
        } catch (InvalidCourseProperty exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseEntity> getCourseById(@PathVariable(value = "id") Long courseID) {
        CourseEntity course = courseRepository.findOne(courseID);
        if(course == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(course);
    }
}
