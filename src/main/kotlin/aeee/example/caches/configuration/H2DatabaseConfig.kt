package aeee.example.caches.configuration

import com.zaxxer.hikari.HikariDataSource
import org.h2.tools.Server
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.sql.SQLException
import javax.sql.DataSource

@Configuration
class H2DatabaseConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    @Throws(SQLException::class)
    fun dataSource(): DataSource? {
        val server: Server = Server.createTcpServer(
            "-tcp",
            "-tcpAllowOthers",
            "-ifNotExists",
            "-tcpPort", "13388"
        ).start()
        return HikariDataSource()
    }
}