/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioBacchi.backend.Security;


import com.PortfolioBacchi.backend.Security.jwt.JwtEntryPoint;
import com.PortfolioBacchi.backend.Security.jwt.JwtTokenFilter;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author W10-PC
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {
   private final UserDetailsService userDetailsService;

   private final JwtEntryPoint unauthorizedHandler;

   private final JwtTokenFilter authenticationJwtTokenFilter;

   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }

   @Bean
   public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
       return authenticationConfiguration.getAuthenticationManager();
   }

   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http.cors().and().csrf().disable()
               .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
               .authorizeRequests()
               .antMatchers(UrlMapping.AUTH + UrlMapping.SIGN_UP).permitAll()
               .antMatchers(UrlMapping.AUTH + UrlMapping.LOGIN).permitAll()
               .antMatchers(UrlMapping.VALIDATE_JWT).permitAll()
               .antMatchers("/api/test/**").permitAll()
               .anyRequest().authenticated();

       http.addFilterBefore(authenticationJwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

       return http.build();
   }

   @Bean
   public WebMvcConfigurer corsConfigurer() {
       return new WebMvcConfigurer() {
           @Override
           public void addCorsMappings(CorsRegistry registry) {
               registry.addMapping("/**")
                       .allowedMethods("*");
           }
       };
   }
}

