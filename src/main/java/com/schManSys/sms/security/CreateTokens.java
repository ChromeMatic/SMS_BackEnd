package com.schManSys.sms.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.schManSys.sms.models.AppUser;
import com.schManSys.sms.models.Roles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
public class CreateTokens {

    public Map<String,String> BuildTokens(Algorithm algorithm, User user,
                                          HttpServletRequest request,
                                          HttpServletResponse response)
            throws IOException, ServletException{

        String accessToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() +45*60*100))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles",user.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);

        String RefreshToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() +45*60*100))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);

        Map<String,String> Tokens = new HashMap<>();
        Tokens.put("access_Token",accessToken);
        Tokens.put("refresh_Token",RefreshToken);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(),Tokens);

        return Tokens;
    }

    public Map<String,String> BuildRefreshToken(Algorithm algorithm, AppUser user,
                                                HttpServletRequest request,
                                                HttpServletResponse response)
            throws IOException, ServletException{


        String RefreshToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() +45*60*100))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles",user.getRoles().stream()
                        .map(Roles::getRoleName).collect(Collectors.toList()))
                .sign(algorithm);


        Map<String,String> refreshTokens = new HashMap<>();
        refreshTokens.put("refresh_Token",RefreshToken);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(),refreshTokens);

        return refreshTokens;
    }
}
