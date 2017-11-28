package courses.validation.impl;

import courses.domain.dto.UserDTO;
import courses.validation.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesImpl implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserDTO userDTO = (UserDTO) obj;
        return userDTO.getPassword().equals(userDTO.getMatchingPassword());
    }
}
