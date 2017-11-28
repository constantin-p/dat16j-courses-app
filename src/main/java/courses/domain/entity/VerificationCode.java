package courses.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Table(name = "verificationcodes")
public class VerificationCode {
    private static final Period LIFESPAN = Period.ofDays(1);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String code;

    @OneToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private UserEntity user;

    private LocalDateTime expirationDate;

    public VerificationCode() {
        super();
    }

    public VerificationCode(String code, UserEntity user) {
        super();

        this.code = code;
        this.user = user;
        this.expirationDate = LocalDateTime.now().plus(LIFESPAN);
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
}
