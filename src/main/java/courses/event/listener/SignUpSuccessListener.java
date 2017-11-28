package courses.event.listener;

import courses.domain.entity.UserEntity;
import courses.event.OnSignUpSuccessEvent;
import courses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SignUpSuccessListener implements ApplicationListener<OnSignUpSuccessEvent> {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messages;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void onApplicationEvent(OnSignUpSuccessEvent event) {
        UserEntity user = event.getUser();
        String code = UUID.randomUUID().toString();

        System.out.println("\n\n ==> Send mail");

        userService.saveVerificationCode(user, code);
        this.sendEmailVerificationEMail(user.getEmail(), code, event);
    }

    private void sendEmailVerificationEMail(String to, String code, OnSignUpSuccessEvent event) {
        String recipientAddress = to;
        String subject = "SignUp Confirmation";
        String confirmationUrl = event.getAppUrl() + "/email-verification.html?code=" + code;

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText("Activation link: " + " \n" + "http://localhost:8080" + confirmationUrl);
        mailSender.send(email);
    }
}
