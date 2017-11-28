package courses.service.impl;

import courses.dao.UserRepository;
import courses.domain.entity.UserEntity;
import courses.domain.entity.UserTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with the following email: " + email);
        }

        return new User(
            user.getEmail(),
            user.getHash(),
            user.isEmailVerified(),
            accountNonExpired,
            credentialsNonExpired,
            accountNonLocked,
            getAuthorities(user.getType()));
    }

    // Helpers
    private static List<GrantedAuthority> getAuthorities(UserTypeEntity userType) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (userType != null) {
            authorities.add(new SimpleGrantedAuthority(userType.getName()));
        }
        return authorities;
    }
}
