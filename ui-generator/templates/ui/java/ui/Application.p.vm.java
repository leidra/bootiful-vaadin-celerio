$output.java($WebUi, "Application")

$output.require("${configuration.rootPackage}.domain.config.CoreConfiguration")##
$output.require("${configuration.rootPackage}.service.config.ServicesConfiguration")##
$output.require("${configuration.rootPackage}.shared.config.SharedConfiguration")##
$output.require("${configuration.rootPackage}.web.ui.config.SecurityConfiguration")##
$output.require("org.springframework.boot.SpringApplication")##
$output.require("org.springframework.boot.autoconfigure.SpringBootApplication")##
$output.require("org.springframework.context.annotation.Import")##

@Import(value = {CoreConfiguration.class, ServicesConfiguration.class, SecurityConfiguration.class, SharedConfiguration.class})
@SpringBootApplication
public class $output.currentClass {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
