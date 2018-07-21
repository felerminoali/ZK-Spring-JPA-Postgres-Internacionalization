/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package municipio.dao;

/**
 *
 * @author user
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ConnectionFactory {

    public static ConnectionFactory factory=null;
    private Connection con;

    public static ConnectionFactory getInstance(){
        if(factory == null){
            return factory = new ConnectionFactory();
        }
        return factory;
    }

    public  ConnectionFactory(){
        System.out.println("Conectando ao banco");
        try {
            con = DriverManager.getConnection("jdbc:postgresql://ec2-54-83-33-213.compute-1.amazonaws.com:5432/demj2v48ftnj5t?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory",
                                             "ucaqslvzvwulkx",
                                         "7701014a92c577ed7b87b292e9ca109ccc92cd35fdd876e9691b14011a95afc9");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection() {
        return con;
    }

    public static void main(String[] args) throws SQLException {
        Connection c = ConnectionFactory.getInstance().getConnection();
    }
}
