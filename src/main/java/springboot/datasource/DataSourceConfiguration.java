package springboot.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import javax.sql.XAConnection;
import javax.sql.XADataSource;
import javax.transaction.xa.XAResource;

@Configuration
public class DataSourceConfiguration {
    @Bean
    @Primary
    public DataSource druidDatasource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test?autoReconnect=true&useUnicode=true");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("rootroot");
        return druidDataSource;
    }

    @Bean
    public XADataSource druidXADataSource(){
        DruidXADataSource druidXADataSource = new DruidXADataSource();
        druidXADataSource.setUrl("jdbc:mysql://localhost:3306/test?autoReconnect=true&useUnicode=true");
        druidXADataSource.setUsername("root");
        druidXADataSource.setPassword("rootroot");

        try {
            XAConnection xaConnection = druidXADataSource.getXAConnection();
            XAResource xaResource = xaConnection.getXAResource();
            // xaResource.start();
        }catch (Exception e){
            //TODO
        }

        return druidXADataSource;
    }
}
