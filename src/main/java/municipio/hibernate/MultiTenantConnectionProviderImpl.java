/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipio.hibernate;



import com.mchange.v2.c3p0.C3P0Registry;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.PooledDataSource;
import org.hibernate.service.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;

/**
 *
 * @author Ussimane
 */
public class MultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    private static final long serialVersionUID = 6241633589847209550L;

    //private BasicDataSource defaultDataSource;
    private ComboPooledDataSource defaultDataSource;

    public MultiTenantConnectionProviderImpl() {
        PooledDataSource pds = C3P0Registry.pooledDataSourceByName("public");
        if (pds == null) {
            System.out.println("Criou novo pool");
            defaultDataSource = new ComboPooledDataSource("demj2v48ftnj5t");
            defaultDataSource.setJdbcUrl("jdbc:postgresql://ec2-54-83-33-213.compute-1.amazonaws.com:5432/demj2v48ftnj5t?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory");
            defaultDataSource.setUser("ucaqslvzvwulkx");
            defaultDataSource.setPassword("7701014a92c577ed7b87b292e9ca109ccc92cd35fdd876e9691b14011a95afc9");
            defaultDataSource.setAcquireIncrement(5);
            defaultDataSource.setMinPoolSize(10);
            defaultDataSource.setMaxPoolSize(1000);
            defaultDataSource.setMaxStatements(1000);
            defaultDataSource.setMaxIdleTime(1500);
            try {
                defaultDataSource.setDriverClass("org.postgresql.Driver");
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MultiTenantConnectionProviderImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
           System.out.println("Nao criou novo pool");
        }

    }

    @Override
    protected DataSource selectAnyDataSource() {
        System.out.println("Criou novo pool; anny data source");
        return defaultDataSource;
    }

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        ComboPooledDataSource cpds = null;
        ComboPooledDataSource pds = (ComboPooledDataSource) C3P0Registry.pooledDataSourceByName(tenantIdentifier);
        if (pds == null) {
            System.out.println("Criou novo pool: "+tenantIdentifier);
            cpds = new ComboPooledDataSource(tenantIdentifier);
            cpds.setJdbcUrl("jdbc:postgresql://ec2-54-83-33-213.compute-1.amazonaws.com:5432/demj2v48ftnj5t?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory");
            cpds.setUser(tenantIdentifier);
            cpds.setPassword("7701014a92c577ed7b87b292e9ca109ccc92cd35fdd876e9691b14011a95afc9");
            cpds.setAcquireIncrement(5);
            cpds.setMinPoolSize(10);
            cpds.setMaxPoolSize(1000);
            cpds.setMaxStatements(1000);
            cpds.setMaxIdleTime(1500);
            try {
                cpds.setDriverClass("org.postgresql.Driver");
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MultiTenantConnectionProviderImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return cpds;
        } else {
                System.out.println("Usou antigo pool: "+tenantIdentifier+pds.getPreferredTestQuery()+"");
        }
        return pds;

    }
}
