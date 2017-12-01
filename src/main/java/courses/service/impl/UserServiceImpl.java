package courses.service.impl;

import courses.dao.UserRepository;
import courses.domain.dto.UserDTO;
import courses.domain.entity.UserEntity;
import courses.service.UserService;
import courses.validation.exception.EmailAlreadyInUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity saveUser(UserDTO userDTO) throws EmailAlreadyInUse {
        if (emailExist(userDTO.getEmail())) {
            throw new EmailAlreadyInUse("Email address already registered: " + userDTO.getEmail());
        }

        // the rest of the registration operation
        final UserEntity user = new UserEntity();

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());

        user.setHash(passwordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(user);
    }


    // Helpers
    private boolean emailExist(String email) {
        UserEntity user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}