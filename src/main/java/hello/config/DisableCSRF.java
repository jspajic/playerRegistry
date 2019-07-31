package hello.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class DisableCSRF extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .formLogin()
//                .and()
//                .httpBasic();

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/register","/swagger**","/webjars/**","/v2/**","/swagger-resources/","/swagger-resources/configuration").permitAll()
                .antMatchers("/api.**").authenticated()
                .anyRequest().authenticated()
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .permitAll();
    }
}