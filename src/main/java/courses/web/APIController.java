package courses.web;

import courses.dao.CourseRepository;
import courses.dao.ProgrammeRepository;
import courses.dao.UserRepository;
import courses.dao.UserTypeRepository;
import courses.domain.dto.CourseDTO;
import courses.domain.dto.ProgrammeDTO;
import courses.domain.entity.CourseEntity;
import courses.domain.entity.ProgrammeEntity;
import courses.domain.entity.UserEntity;
import courses.service.CourseService;
import courses.service.ProgrammeService;
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
    private ProgrammeRepository programmeRepository;

    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

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

    @PutMapping("/courses/{id}")
    public ResponseEntity<CourseEntity> getCourseById(@PathVariable(value = "id") Long courseID,
                                                      @Valid @RequestBody CourseDTO courseDTO) {
        CourseEntity course = courseRepository.findOne(courseID);
        if(course == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            return ResponseEntity.ok().body(courseService.updateCourse(course, courseDTO));
        } catch (InvalidCourseProperty exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<CourseEntity> deleteCourse(@PathVariable(value = "id") Long courseID) {
        CourseEntity course = courseRepository.findOne(courseID);
        if(course == null) {
            return ResponseEntity.notFound().build();
        }

        courseRepository.delete(course);
        return ResponseEntity.ok().build();
    }

    // Teachers
    @GetMapping("/teachers")
    public List<UserEntity> getAllTeachers() {
        return userRepository.findByType(userTypeRepository.findByName("TEACHER"));
    }

    // Students
    @GetMapping("/students")
    public List<UserEntity> getAllStudents() {
        return userRepository.findByType(userTypeRepository.findByName("STUDENT"));
    }
}
