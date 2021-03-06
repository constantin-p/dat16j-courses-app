package courses.web;

import courses.domain.dto.UserDTO;
import courses.domain.entity.UserEntity;

import courses.security.CustomUser;
import courses.service.UserService;
import courses.validation.exception.EmailAlreadyInUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

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

    @RequestMapping("/sign-out")
    public String signOut(HttpSession session) {
        session.invalidate();
        return "redirect:/sign-in.html";
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

    protected static void injectUserData(Model model, Authentication authentication) {
        UserEntity user = ((CustomUser)authentication.getPrincipal()).getUser();

        model.addAttribute("ID", user.getID());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("initials", user.getFirstName().substring(0, 1) + user.getLastName().substring(0, 1));
    }
}