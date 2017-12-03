package courses.web;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public String showDefault(WebRequest request, Model model, Authentication authentication) {
        UserController.injectUserData(model, authentication);

        return "redirect:/admin/applications";
    }

    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    public String showCourses(WebRequest request, Model model, Authentication authentication) {
        UserController.injectUserData(model, authentication);

        return "admin-applications";
    }

}
