package courses.service;

import courses.domain.dto.UserDTO;
import courses.domain.entity.UserEntity;
import courses.validation.exception.EmailAlreadyInUse;

public interface UserService {
    UserEntity saveUser(UserDTO userDTO) throws EmailAlreadyInUse;
}
