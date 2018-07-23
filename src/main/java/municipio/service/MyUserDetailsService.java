package municipio.service;

import municipio.dao.ConnectionFactory;
import municipio.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    private static final Map<String, MyUser> USERS = new HashMap<String,MyUser>();
    private static void add(MyUser mu){
        USERS.put(mu.getUsername(), mu);
    }
    static{

        add(new MyUser("rod","81dc9bdb52d04dc20036dbd8313ed055", //password:1234
                new String[]{"ROLE_USER", "ROLE_EDITOR"} ));

        add(new MyUser("dianne","81dc9bdb52d04dc20036dbd8313ed055",
                new String[]{"ROLE_USER", "ROLE_EDITOR"} ));

        add(new MyUser("scott","81dc9bdb52d04dc20036dbd8313ed055",
                new String[]{"ROLE_USER"} ));

        add(new MyUser("peter","81dc9bdb52d04dc20036dbd8313ed055",
                new String[]{"ROLE_USER"} ));
    }

    // must return a value or throw UsernameNotFoundException
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        //perform authentication
        throw new UnsupportedOperationException();
    }
}
