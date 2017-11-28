package courses.dao;

import courses.domain.entity.UserEntity;
import courses.domain.entity.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Long> {
    VerificationCode findByCode(String code);
    VerificationCode findByUser(UserEntity user);
}
