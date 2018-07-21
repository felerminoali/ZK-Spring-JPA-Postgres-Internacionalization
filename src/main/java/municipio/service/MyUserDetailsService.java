package municipio.service;

import municipio.dao.ConnectionFactory;
import municipio.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private CRUDService CRUDService;
    @Autowired
    SessionFactory sessionFactory;
//    static 
    static municipio.model.User dbUser = new municipio.model.User();

    /*
     * You just have to make sure that the user-by-username-query returns three
     * fields. 1) the userName 2) the password 3) boolean for is the user
     * active. If you don't have an active field, make your query always return
     * true for that third field.
     */
    public UserDetails loadUserByUsername(String username){
            throw new UnsupportedOperationException();
    }

    /**
     * Retrieves the correct ROLE type depending on the access level, where
     * access level is an Integer. Basically, this interprets the access value
     * whether it's for a regular user or admin.
     *
     */
    public Collection<GrantedAuthority> getAuthorities(String u) throws SQLException {
        // Create a list of grants for this user
        throw new UnsupportedOperationException();
    }
}
