package courses.config;

import courses.security.CustomAuthenticationSuccessHandler;
import courses.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private CustomAuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
            .antMatchers("/css/**").permitAll()
            .antMatchers("/sign-in*", "/sign-up*").anonymous()
            .antMatchers("/teacher*").hasAuthority("TEACHER")
            .antMatchers("/student*").hasAuthority("STUDENT")
            .antMatchers("/admin*").hasAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/sign-in.html")
            .successHandler(authenticationSuccessHandler)
            .failureUrl("/sign-in.html?error=true")
            .and()
        .logout()
            .logoutUrl("/sign-out")
            .logoutSuccessUrl("/sign-in.html");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
