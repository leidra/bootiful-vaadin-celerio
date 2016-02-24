$output.java("${configuration.rootPackage}.shared.config", "SharedConfiguration")##

$output.require("${configuration.rootPackage}.shared.services.SharedPackageProvider")##
$output.require("ma.glasnost.orika.MapperFacade")##
$output.require("ma.glasnost.orika.impl.DefaultMapperFactory")##
$output.require("org.springframework.context.annotation.Bean")##
$output.require("org.springframework.context.annotation.ComponentScan")##
$output.require("org.springframework.context.annotation.Configuration")##

@Configuration
@ComponentScan(basePackageClasses = SharedPackageProvider.class)
public class $output.currentClass {
    @Bean
    public MapperFacade createMapperFacade() {
        return new DefaultMapperFactory.Builder().build().getMapperFacade();
    }
}