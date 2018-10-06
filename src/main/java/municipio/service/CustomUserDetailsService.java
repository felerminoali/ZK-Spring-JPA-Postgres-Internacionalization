package municipio.service;

import municipio.domain.CustomUserDetails;
import municipio.domain.Role;
import municipio.domain.Users;
import municipio.modelo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    @Qualifier("CRUDServiceImpl")
//    private UsersRepository usersRepository;
    private CRUDService crudService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException,
            DataAccessException {

//            Optional<Users> optionalUsers = usersRepository.findByName(username);

        Users u = new Users();
        u.setId(1);
        u.setName("admin");
        u.setPassword("admin");
        Set<Role> roleSet = new HashSet<Role>();

        Role r = new Role();
        r.setRoleId(1);
        r.setRole("ADMIN");
        roleSet.add(r);
        u.setRoles(roleSet);

//        Users u = crudService.findEntByJPQueryT("SELECT u FROM Users u WHERE u.name = 'admin'", null);
//        u.setRoles(u.getRoles());
        u.setRoles(roleSet);
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
