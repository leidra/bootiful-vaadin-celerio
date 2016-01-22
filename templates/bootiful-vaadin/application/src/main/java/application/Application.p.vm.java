$output.java($Root,"Application")##

$output.require("org.slf4j.Logger")##
$output.require("org.slf4j.LoggerFactory")##
$output.require("org.springframework.boot.SpringApplication")##
$output.require("org.springframework.boot.autoconfigure.SpringBootApplication")##
$output.require("org.springframework.context.annotation.Import")##
$output.require("${configuration.rootPackage}.core.config.CoreConfiguration")##

@Import(value = {CoreConfiguration.class, ServicesConfiguration.class, SecurityConfiguration.class})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
