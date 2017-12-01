package courses.domain.dto;

import courses.validation.PasswordMatches;
import courses.validation.ValidEmail;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@PasswordMatches(message = "error.auth.differentPasswords")
public class UserDTO {
    @NotNull
    @NotEmpty(message = "error.auth.emptyField")
    private String firstName;

    @NotNull
    @NotEmpty(message = "error.auth.emptyField")
    private String lastName;

    @NotNull
    @NotEmpty(message = "error.auth.emptyField")
    @ValidEmail(message = "error.auth.invalidEmail")
    private String email;

    @NotNull
    @NotEmpty(message = "error.auth.emptyField")
    private String password;
    private String matchingPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
