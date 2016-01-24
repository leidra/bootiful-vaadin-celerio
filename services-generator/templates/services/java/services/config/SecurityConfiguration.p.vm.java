$output.java("${Service}.config","SecurityConfiguration")##

$output.require("org.springframework.boot.autoconfigure.security.SecurityProperties")##
$output.require("org.springframework.context.annotation.Bean")##
$output.require("org.springframework.context.annotation.Configuration")##
$output.require("org.springframework.core.annotation.Order")##
$output.require("org.springframework.data.domain.AuditorAware")##
$output.require("org.springframework.security.authentication.AuthenticationManager")##
$output.require("org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder")##
$output.require("org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity")##
$output.require("org.springframework.security.config.annotation.web.builders.HttpSecurity")##
$output.require("org.springframework.security.config.annotation.web.builders.WebSecurity")##
$output.require("org.springframework.security.config.annotation.web.configuration.EnableWebSecurity")##
$output.require("org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter")##
$output.require("org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint")##
$output.require("org.vaadin.spring.security.annotation.EnableVaadinSharedSecurity")##
$output.require("org.vaadin.spring.security.config.AuthenticationManagerConfigurer")##

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, proxyTargetClass = true)
@EnableVaadinSharedSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter implements AuthenticationManagerConfigurer {
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // Use Vaadin's built-in CSRF protection instead
        http.authorizeRequests()
                .antMatchers("/login/**").anonymous()
                .antMatchers("/vaadinServlet/UIDL/**").permitAll()
                .antMatchers("/vaadinServlet/HEARTBEAT/**").permitAll()
                .anyRequest().authenticated();
        http.httpBasic().disable();
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll();
        http.exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/VAADIN/**");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuditorAware<String> createAuditorProvider() {
        return new SecurityAuditor();
    }

    public static class SecurityAuditor implements AuditorAware<String> {
        @Override
        public String getCurrentAuditor() {
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            return auth.getName();
            return "leidra";
        }
    }
}