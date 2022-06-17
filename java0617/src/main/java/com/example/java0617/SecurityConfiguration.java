package com.example.java0617;

import com.example.java0617.filter.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;

public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/create/**").permitAll()
                .antMatchers("/login/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic().disable();

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
