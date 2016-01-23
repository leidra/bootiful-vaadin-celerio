$output.java("${configuration.rootPackage}.domain.config", "CoreConfiguration")##

$output.require("${configuration.rootPackage}.core.domain.EntitiesPackageProvider")##
$output.require("${configuration.rootPackage}.core.repositories.RepositoriesPackageProvider")##
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = EntitiesPackageProvider.class)
@EnableJpaRepositories(basePackageClasses = RepositoriesPackageProvider.class)
public class $output.currentClass {
}