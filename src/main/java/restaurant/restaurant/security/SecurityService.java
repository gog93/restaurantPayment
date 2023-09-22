package restaurant.restaurant.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import restaurant.restaurant.model.Admin;
import restaurant.restaurant.model.User;
import restaurant.restaurant.rest.repository.AdminRepository;
import restaurant.restaurant.rest.repository.UserRepository;

import java.util.Optional;

@Service
public class SecurityService implements UserDetailsService {
    @Autowired
    private final AdminRepository adminRepository;
    @Autowired
    private final UserRepository userRepository;

    public SecurityService(AdminRepository adminRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Admin> byEmail = adminRepository.findByEmail(s);
        Optional<User> byLogin = userRepository.findByLogin(s);
        if (byEmail.isPresent()) {
            return new CurrentUser(byEmail.get());

        } if (byLogin.isPresent()) {
            return new CurrentUser(byLogin.get());

        }
        throw new UsernameNotFoundException("User with " + s + " username does not exists");

    }
}

