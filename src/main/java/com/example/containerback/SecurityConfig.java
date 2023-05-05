package com.example.containerback;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

    public SecurityConfig(JwtTokenProvider jwtTokenProvider, ObjectMapper objectMapper) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.objectMapper = objectMapper;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .cors().and()
                .formLogin().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .requestMatchers("/auth/*").permitAll()
                .requestMatchers(HttpMethod.GET, "/mustSignIn").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/**").permitAll()
                .anyRequest().hasRole("USER")
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider, objectMapper), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
