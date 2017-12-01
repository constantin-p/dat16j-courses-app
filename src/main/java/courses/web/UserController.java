package courses.web;

import courses.domain.dto.UserDTO;
import courses.domain.entity.UserEntity;

import courses.service.UserService;
import courses.validation.exception.EmailAlreadyInUse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/sign-up.html", method = RequestMethod.GET)
    public String showSignUpForm(WebRequest request, Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "sign-up";
    }

    @RequestMapping(value = "/sign-up.html", method = RequestMethod.POST)
    public ModelAndView signUp(@ModelAttribute("user") @Valid UserDTO userDTO,
            BindingResult result, WebRequest request, Errors errors) {

        UserEntity newUser = new UserEntity();

        if (!result.hasErrors()) {
            newUser = createUser(userDTO, result);
        }
        if (newUser == null) {
            result.rejectValue("email", "error.auth.credentialAlreadyInUse");
        }

        if (result.hasErrors()) {
            return new ModelAndView("sign-up", "user", userDTO);
        } else {
            return new ModelAndView("redirect:/sign-in.html");
        }
    }


    // Helpers
    private UserEntity createUser(UserDTO userDTO, BindingResult result) {
        UserEntity newUser = null;
        try {
            newUser = userService.saveUser(userDTO);
        } catch (EmailAlreadyInUse exception) {
            return null;
        }
        return newUser;
    }
}