package municipio.service;

import esira.dao.ConnectionFactory;
import esira.domain.Users;
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
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private CRUDService CRUDService;
    @Autowired
    SessionFactory sessionFactory;
//    static 
    static Users dbUser = new Users();

    /*
     * You just have to make sure that the user-by-username-query returns three
     * fields. 1) the userName 2) the password 3) boolean for is the user
     * active. If you don't have an active field, make your query always return
     * true for that third field.
     */
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        // Declare a null Spring User
        UserDetails user = null;

        try {

            // Search database for a user that matches the specified username
            // You can provide a custom DAO to access your persistence layer
            // Or use JDBC to access your database
            // DbUser is our custom domain user. This is not the same as
            // Spring's User
            dbUser = CRUDService.GetUniqueEntityByNamedQuery(
                    "Users.findByUtilizador", username);
            //  dbUser.getIdGrupo().
            //   for (esira.domain.Item i : dbUser.getIdGrupo().getItemList()) {
           // UserAutentic.setUser(dbUser.getUtilizador());
//            UserAutentic.setUestudante(dbUser.getUestudante());
            //UserAutentic.setIdf(dbUser.getIdUtilizador());
             //UserAutentic.setIdfac(dbUser.getFaculdade());
          //  }

            // Populate the Spring User object with details from the dbUser
            // Here we just pass the username, password, and access level
            // getAuthorities() will translate the access level to the correctdbUser.getIdGrupo().getItemList().get(0).getCategoria().getIdCategoria()
            // role type
            
            user = new User(dbUser.getUtilizador(), dbUser.getPasword()
                    .toLowerCase(), true, true, true, true,
                    getAuthorities(dbUser.getUtilizador()));

        } catch (Exception e) {
            throw new UsernameNotFoundException("Error in retrieving user");
        }
        return user;
    }

    /**
     * Retrieves the correct ROLE type depending on the access level, where
     * access level is an Integer. Basically, this interprets the access value
     * whether it's for a regular user or admin.
     *
     * @param access an integer value representing the access of the user
     * @return collection of granted authorities
     */
    public Collection<GrantedAuthority> getAuthorities(String u) throws SQLException {
        // Create a list of grants for this user
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        // All users are granted with ROLE_USER access
        // Therefore this user gets a ROLE_USER by default

        //String sql = "select * from fecn1.acesso('"+UserAutentic.getUser()+"')";
        String sql = " select r.id_categoria as acesso from fecn1.roles r, fecn1.users u where r.id_grupo = u.id_grupo AND "
                + "  u.utilizador = ? GROUP BY r.id_categoria union select r.id_item from  fecn1.roles r, fecn1.users u where r.id_grupo = u.id_grupo AND "
                + "  u.utilizador = ?";
        //CallableStatement callableStmt = ConnectionFactory.getInstance().getConnection().prepareCall(sql);
        PreparedStatement pstm = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1, u);
        pstm.setString(2, u);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            authList.add(new GrantedAuthorityImpl(rs.getString("acesso")));
        }
        rs.close();
        pstm.close();
        return authList;
    }
}
