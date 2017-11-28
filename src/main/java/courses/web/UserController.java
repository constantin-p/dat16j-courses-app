package courses.web;

import courses.domain.dto.UserDTO;
import courses.domain.entity.UserEntity;

import courses.domain.entity.VerificationCode;
import courses.event.OnSignUpSuccessEvent;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Controller
public class UserController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    private MessageSource messages;


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
        // TODO: Remove
        System.out.println("\n\n ==> " + (!result.hasErrors()) + errors);
        if (!result.hasErrors()) {
            newUser = createUser(userDTO, result);
        }
        if (newUser == null) {
            result.rejectValue("email", "message.auth.credentialAlreadyInUse");
        }
        try {
            String appUrl = request.getContextPath();
            eventPublisher.publishEvent(new OnSignUpSuccessEvent(newUser, this.parseLocale(request.getLocale().getLanguage()), appUrl));
        } catch (Exception exception) {
            System.out.println("\n\n ==> signUp Exception" + exception);
            return new ModelAndView("sign-up", "user", userDTO);
        }
        System.out.println("\n\n ==> signUp OK");
        return new ModelAndView("sign-in");
    }


    @RequestMapping(value = "/email-verification.html", method = RequestMethod.GET)
    public String confirmEmail(WebRequest request, Model model, @RequestParam("code") String code) {
        Locale locale = request.getLocale();

        VerificationCode verificationCode = userService.getVerificationCode(code);
        if (verificationCode == null) {
            //String message = messages.getMessage("message.auth.verificationCodeInvalid", null, locale);
            model.addAttribute("messages", "message.auth.verificationCodeInvalid");
            return "redirect:/email-verification.html?lang=" + locale.getLanguage();
        }

        UserEntity user = verificationCode.getUser();
        if (!verificationCode.getExpirationDate().isAfter(LocalDateTime.now())) {
            //String messageValue = messages.getMessage("message.auth.verificationCodeExpired", null, locale);
            model.addAttribute("messages", "message.auth.verificationCodeExpired");
            return "redirect:/email-verification.html?lang=" + locale.getLanguage();
        }

        userService.validateEmail(user);
        return "redirect:/sign-in.html?lang=" + request.getLocale().getLanguage();
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

    // TODO: Use LocaleResolver
    private String parseLocale(String locale) {
        List<String> supportedOptions = Arrays.asList(new String[] {"en", "da"});
        for(String option: supportedOptions) {
            if (locale.startsWith(option)) {
                return option;
            }
        }
        return supportedOptions.get(0);
    }
}