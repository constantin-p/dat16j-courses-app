package courses.web;

import courses.dao.CourseRepository;
import courses.domain.dto.UserDTO;
import courses.domain.entity.CourseEntity;
import courses.domain.entity.UserEntity;
import courses.validation.exception.EmailAlreadyInUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@RequestMapping("/teacher")
@Controller
public class TeacherController {

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String showDefault(WebRequest request, Model model, Authentication authentication) {
        UserController.injectUserData(model, authentication);

        return "redirect:/teacher/courses";
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String showCourses(WebRequest request, Model model, Authentication authentication) {
        UserController.injectUserData(model, authentication);

        return "courses";
    }

    @RequestMapping(value = "/courses/new", method = RequestMethod.GET)
    public String showNewCourse(WebRequest request, Model model, Authentication authentication) {
        UserController.injectUserData(model, authentication);

        return "courses-new";
    }

    @RequestMapping(value = "/courses/edit/{courseID}", method = RequestMethod.GET)
    public String showEditCourse(WebRequest request, Model model, Authentication authentication, @PathVariable(value = "courseID") Long courseID) {
        UserController.injectUserData(model, authentication);
        System.out.println(" == > " + courseID);
        CourseEntity course = courseRepository.findOne(courseID);
        if(course == null) {
            // TODO: Show error message
            return "courses";
        }

        model.addAttribute("course", course);
        return "courses-edit";
    }

}
