package com.schManSys.sms.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.schManSys.sms.models.AppUser;
import com.schManSys.sms.models.Roles;
import com.schManSys.sms.services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@CrossOrigin("*")
@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
@Slf4j
public class AuthControllers {

    private final UserService userService;

    @PostMapping("login")
    public ResponseEntity<?> Login(@RequestBody LoginFrom loginFrom){
        System.out.println(loginFrom);
        return ResponseEntity.ok().build();
    }

    @GetMapping("RefreshToken")
    public void RefreshToken(HttpServletRequest request,
                             HttpServletResponse response)
            throws  IOException {

        String header = request.getHeader(AUTHORIZATION);

        if (header != null && header.startsWith("Bearer ")) {
            try {

                String RefreshToken = header.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decoder = jwtVerifier.verify(RefreshToken);

                String username = decoder.getSubject();
                AppUser user = userService.getUserByUsername(username);

                String accessToken = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() +75*60*100))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles",user.getRoles().stream()
                                .map(Roles::getRoleName).collect(Collectors.toList()))
                        .sign(algorithm);


                Map<String,String> Tokens = new HashMap<>();
                Tokens.put("access_Token",accessToken);
                Tokens.put("refresh_Token",RefreshToken);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),Tokens);


            } catch (Exception e) {
                log.error("Error logging in: {}",e.getMessage());
                response.setHeader("Error",e.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String,String> Error = new HashMap<>();
                Error.put("Error Message",e.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),Error);
            }
        } else {
            throw new RemoteException("Refresh token is missing.");
        }

    }
}

@Data
class LoginFrom{
    private String username;
    private String password;
}
