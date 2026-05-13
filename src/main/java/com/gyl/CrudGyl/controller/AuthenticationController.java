package com.gyl.CrudGyl.controller;

import com.gyl.CrudGyl.dto.resquest.LoginResquest;
import com.gyl.CrudGyl.security.JwtUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticationController
{
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginResquest loginResquest)
    {
        try
        {
            //Autenticar al usuario (Spring lo busca en la DB y compara constraseñas)
            Authentication authenticacion = authenticationManager.authenticate
                    (
                            new UsernamePasswordAuthenticationToken
                                    (
                                            loginResquest.username(),
                                            loginResquest.password()
                                    )
                    );
            //si la autenticacion fue exitosa, generamos el token
            String token = jwtUtils.generateToken(authenticacion.getName());

            //Devolvemos el token en un mapa o DTO
            Map<String, String> response = new HashMap<>();
            response.put("token", token);

            return ResponseEntity.ok(response);
        }
        catch (AuthenticationException exception)
        {
            //Si falla (usuario o clave incorrecta)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
