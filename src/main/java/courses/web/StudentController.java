package courses.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@RequestMapping("/student")
@Controller
public class StudentController {

    @RequestMapping(method = RequestMethod.GET)
    public String showDefault(WebRequest request, Model model) {
        return "teacher";
    }

}