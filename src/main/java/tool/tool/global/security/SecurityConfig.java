package tool.tool.global.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;
import tool.tool.domain.user.domain.type.Authority;
import tool.tool.global.error.filter.ExceptionFilter;
import tool.tool.global.security.jwt.JwtTokenProvider;
import tool.tool.global.security.jwt.auth.AuthDetails;
import tool.tool.global.security.jwt.auth.AuthDetailsService;
import tool.tool.global.security.jwt.filter.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthDetailsService authDetailsService;
    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper mapper;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .formLogin().disable()
                .cors()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/swagger-ui.html").permitAll()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/groupBuying/list").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/groupBuying/{id}").permitAll()
                .requestMatchers("/api/board/list").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/comment/{boardId}").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/question/{groupBuyingId}").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/answer/{questionId}").permitAll()
                .requestMatchers("/api/chat").permitAll()
                .requestMatchers("/api/image/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider, authDetailsService), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new ExceptionFilter(mapper), JwtAuthenticationFilter.class);


        return http.build();
    }
}
