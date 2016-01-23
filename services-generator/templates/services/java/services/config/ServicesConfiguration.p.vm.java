$output.java($ServiceSupport, "ServicesConfiguration")##

$output.require($Service, "ServicesPackageProvider")##
$output.require("org.springframework.context.annotation.ComponentScan")##
$output.require("org.springframework.context.annotation.Configuration")##

@Configuration
@ComponentScan(basePackageClasses = ServicesPackageProvider.class)
public class $output.currentClass {
}