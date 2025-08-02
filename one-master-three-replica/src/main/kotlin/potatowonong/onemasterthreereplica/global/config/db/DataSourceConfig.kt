package potatowonong.onemasterthreereplica.global.config.db

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
import javax.sql.DataSource

@Configuration
class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.hikari.master")
    fun masterDataSource(): DataSource =
        DataSourceBuilder.create()
            .type(HikariDataSource::class.java)
            .build()

    @Bean
    @ConfigurationProperties("spring.datasource.hikari.replica")
    fun slaveDataSource(): DataSource =
        DataSourceBuilder.create()
            .type(HikariDataSource::class.java)
            .build()

    @Bean
    fun routingDataSource(): DataSource {
        val routingDataSource = ReplicationRoutingDataSource()
        val targetDataSource = mapOf(
            DataSourceType.MASTER to masterDataSource(),
            DataSourceType.REPLICA to slaveDataSource()
        )
        routingDataSource.setTargetDataSources(targetDataSource as Map<Any, Any>)
        routingDataSource.setDefaultTargetDataSource(masterDataSource())

        return routingDataSource
    }

    @Primary
    @Bean
    fun datasource(): DataSource = LazyConnectionDataSourceProxy(routingDataSource())
}