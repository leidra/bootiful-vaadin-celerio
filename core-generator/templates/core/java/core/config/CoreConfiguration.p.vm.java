$output.java("${configuration.rootPackage}.domain.config", "CoreConfiguration")##

$output.require("${configuration.rootPackage}.domain.EntitiesPackageProvider")##
$output.require("${configuration.rootPackage}.repository.RepositoriesPackageProvider")##
$output.require("org.springframework.boot.orm.jpa.EntityScan")##
$output.require("org.springframework.context.annotation.Configuration")##
$output.require("org.springframework.data.jpa.repository.config.EnableJpaRepositories")##

@Configuration
@EntityScan(basePackageClasses = EntitiesPackageProvider.class)
@EnableJpaRepositories(basePackageClasses = RepositoriesPackageProvider.class)
public class $output.currentClass {
}