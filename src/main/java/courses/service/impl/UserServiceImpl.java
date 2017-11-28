package courses.service.impl;

import courses.dao.UserRepository;
import courses.dao.VerificationCodeRepository;
import courses.domain.dto.UserDTO;
import courses.domain.entity.UserEntity;
import courses.domain.entity.VerificationCode;
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
    private VerificationCodeRepository verificationCodeRepository;

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

    @Override
    public UserEntity getUser(String code) {
        return verificationCodeRepository.findByCode(code).getUser();
    }

    @Override
    public void validateEmail(UserEntity user) {
        user.setEmailVerified(true);
        userRepository.save(user);
    }


    @Override
    public void saveVerificationCode(UserEntity user, String code) {
        VerificationCode verificationCode = new VerificationCode(code, user);
        verificationCodeRepository.save(verificationCode);
    }

    @Override
    public VerificationCode getVerificationCode(String code) {
        return verificationCodeRepository.findByCode(code);
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