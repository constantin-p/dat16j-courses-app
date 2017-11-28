package courses.service;

import courses.domain.dto.UserDTO;
import courses.domain.entity.UserEntity;
import courses.domain.entity.VerificationCode;
import courses.validation.exception.EmailAlreadyInUse;

public interface UserService {
    UserEntity saveUser(UserDTO userDTO) throws EmailAlreadyInUse;
    UserEntity getUser(String verificationCode);
    void validateEmail(UserEntity user);

    void saveVerificationCode(UserEntity user, String token);
    VerificationCode getVerificationCode(String code);
}
