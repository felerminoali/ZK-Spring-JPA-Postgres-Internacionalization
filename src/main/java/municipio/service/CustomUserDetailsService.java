package municipio.service;

import municipio.domain.CustomUserDetails;
import municipio.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    @Qualifier("CRUDServiceImpl")
    private CRUDService crudService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException,
            DataAccessException {

        Users u = crudService.findEntByJPQueryT("SELECT u FROM Users u WHERE u.name = '"+username+"'", null);
        Optional<Users> optionalUsers = Optional.of(u);

            optionalUsers
                    .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
            CustomUserDetails customUserDetails = optionalUsers
                    .map(users -> {
                        return new CustomUserDetails(users);
                    }).get();
            return customUserDetails;

    }
}
