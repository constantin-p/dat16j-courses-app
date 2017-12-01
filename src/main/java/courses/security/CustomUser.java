package courses.security;

import courses.domain.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {
    private final UserEntity user;


    public CustomUser(UserEntity user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getEmail(), user.getHash(), authorities);
        this.user = user;
    }

    public CustomUser(UserEntity user, boolean enabled, boolean accountNonExpired,
                         boolean credentialsNonExpired,
                         boolean accountNonLocked,
                         Collection<? extends GrantedAuthority> authorities) {
        super(user.getEmail(), user.getHash(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }

    public UserEntity getUser() {
        return this.user;
    }
}
