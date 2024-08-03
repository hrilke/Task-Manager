package spring.project.Task_Manager.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import spring.project.Task_Manager.Service.UserService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig{

    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    public AppSecurityConfig(JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/register", "/login").permitAll()
                            .anyRequest().authenticated())
                                .addFilterBefore(jwtAuthenticationFilter(httpSecurity), UsernamePasswordAuthenticationFilter.class);
                return httpSecurity.build();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(HttpSecurity httpSecurity) throws Exception {
        return new JwtAuthenticationFilter(authenticationManager(httpSecurity), jwtTokenProvider);
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(httpSecurity.getSharedObject(AuthenticationConfiguration.class).getAuthenticationConfiguration());
        authenticationManagerBuilder.userDetailsService(userService);
        return authenticationManagerBuilder.build();
    }


}
