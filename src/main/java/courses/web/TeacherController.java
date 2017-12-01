package courses.web;

import courses.domain.dto.UserDTO;
import courses.domain.entity.UserEntity;
import courses.validation.exception.EmailAlreadyInUse;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@RequestMapping("/teacher")
@Controller
public class TeacherController {

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

        return "/teacher/courses";
    }

    @RequestMapping(value = "/courses/edit/{courseID}", method = RequestMethod.GET)
    public String showEditCourse(WebRequest request, Model model, Authentication authentication) {
        UserController.injectUserData(model, authentication);

        return "/teacher/courses";
    }


}
