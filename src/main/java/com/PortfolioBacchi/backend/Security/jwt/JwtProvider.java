/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioBacchi.backend.Security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
     private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

     @Value("$(jwt.secret)")
     private String secret;
     @Value("$(jwt.expiration)")
     private int expiration;
     
     
     public String generateToken(Authentication authentication){
         UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
     }
}
