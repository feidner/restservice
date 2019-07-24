package hfe;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Es existieren die beiden Properties, via applciation.xml oder via AuthenticationManagerBuilder
 *      spring.security.user.name
 *      spring.security.user.password
 *  Sind diese nicht angegeben, so wird beim Start der SpringBoot-Anwendung ein Passwort generiert, der Benutzername ist 'user'.
 *
 */
@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ServerSecurityManager extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("hfe")
                .password("{noop}hfe")
                .roles("HFE");
    }
}