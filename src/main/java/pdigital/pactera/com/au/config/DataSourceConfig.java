package pdigital.pactera.com.au.config;

import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

/**
 * Interface for data source
 */
@Configuration
public interface DataSourceConfig {
    DataSource dataSource();
}