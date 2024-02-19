package code.craft.documents.Utils

import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.MySQLContainer

class MysqlContextInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {

    class CustomMysqlContainer(imageName: String) : MySQLContainer<CustomMysqlContainer>(imageName)

    companion object {
        val mysqlContainer: CustomMysqlContainer = CustomMysqlContainer("mysql:8.0.33")
    }

    override fun initialize(context: ConfigurableApplicationContext) {
        val dbName = context.environment.getProperty("spring.datasource.url")!!
                .substringAfterLast("/")
                .substringBefore("?")
        mysqlContainer.withDatabaseName(dbName)
                .withReuse(true)
                .withLabel("reuse.UUID", dbName)
                .start()
        TestPropertyValues.of(
                "spring.datasource.url=${mysqlContainer.jdbcUrl}?allowMultiQueries=true",
                "spring.datasource.username=root",
                "spring.datasource.password=test")
                .applyTo(context.environment)
    }
}