$output.java($Root, "Application")

$output.require("${configuration.rootPackage}.core.CoreConfiguration")##
$output.require("${configuration.rootPackage}.core.ServicesConfiguration")##
$output.require("org.springframework.boot.SpringApplication")##
$output.require("org.springframework.boot.autoconfigure.SpringBootApplication")##
$output.require("org.springframework.context.annotation.Import")##

@Import(value = {CoreConfiguration.class, ServicesConfiguration.class, SecurityConfiguration.class})
@SpringBootApplication
public class $output.currentClass {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
