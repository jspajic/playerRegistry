package hello.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
//                    .antMatchers("/swagger**", "/webjars/**", "/v2/**", "/swagger-resources/", "/swagger-resources/configuration/**").permitAll()
                    .antMatchers("/api/player","/api/player/edit/{id}").hasAuthority("WRITE_PRIVILEGES")
                    .antMatchers(HttpMethod.DELETE,"/api/player/{id}").hasAuthority("WRITE_PRIVILEGES")
                    .antMatchers(HttpMethod.POST,"/api/player").hasAuthority("WRITE_PRIVILEGES")
                    .antMatchers("/api/players","/api/player/{id}","/api/search**").hasAuthority("READ_PRIVILEGES")
                    .anyRequest().authenticated()
                .and()
                    .httpBasic()
                .and()
                    .logout()
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .permitAll();
    }
}