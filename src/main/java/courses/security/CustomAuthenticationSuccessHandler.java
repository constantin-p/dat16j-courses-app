package courses.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ADMIN")) {
            response.sendRedirect("admin");
        } else if (roles.contains("TEACHER")) {
            response.sendRedirect("teacher");
        } else if (roles.contains("STUDENT")) {
            response.sendRedirect("student");
        } else {
            response.sendRedirect("home.html");
        }
    }
}


