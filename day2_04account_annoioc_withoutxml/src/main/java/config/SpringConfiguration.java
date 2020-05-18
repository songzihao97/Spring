package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 该类是一个配置类，作用与bean.xml相同
 * spring中新注解
 * Configuration：指定当前类为配置类
 * ComponentScan：用于通过注解指定spring在创建容器时要扫描的包
 *      属性value/basePackages：用于指定要扫描的包
 * Bean:把当前方法的返回值作为bean存入spring的ioc容器中
 *      属性value用于指定bean的id，默认值时当前方法的名称
 */
@Configurable
@ComponentScan(basePackages = "com.szh")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {


}
