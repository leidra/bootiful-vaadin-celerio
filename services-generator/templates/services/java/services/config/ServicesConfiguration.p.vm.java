$output.java("${configuration.rootPackage}.service.config", "ServicesConfiguration")##

$output.require($Service, "ServicesPackageProvider")##
$output.require("ma.glasnost.orika.MapperFacade")##
$output.require("ma.glasnost.orika.impl.DefaultMapperFactory")##
$output.require("org.springframework.context.annotation.Bean")##
$output.require("org.springframework.context.annotation.ComponentScan")##
$output.require("org.springframework.context.annotation.Configuration")##

@Configuration
@ComponentScan(basePackageClasses = ServicesPackageProvider.class)
public class $output.currentClass {
    @Bean
    public MapperFacade createMapperFacade() {
        return new DefaultMapperFactory.Builder().build().getMapperFacade();
    }
}