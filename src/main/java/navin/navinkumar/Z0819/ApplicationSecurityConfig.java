package navin.navinkumar.Z0819;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("$2a$10$KkHCsqbw.nqjZBgqABvQkuGraYDEwYdutfhOPi0CwO95TPn0.TyPS")
                .roles("ADMIN").and()
                .withUser("employee")
                .password("$2a$10$KkHCsqbw.nqjZBgqABvQkuGraYDEwYdutfhOPi0CwO95TPn0.TyPS")
                .roles("EMPLOYEE");
        ;
    }

    @Bean
    public PasswordEncoder getPassEncode() {
        return new BCryptPasswordEncoder(10);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/employee/wish").permitAll()
                .antMatchers("/employee/fetch/*").hasAnyRole("EMPLOYEE", "ADMIN")
                .antMatchers("/employee/fetchall").hasRole("ADMIN")
                .and().formLogin();
    }
}
