package com.gyl.CrudGyl.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils
{
    /**
     * Es una clase para manejar la lógica del token. Necesitarás métodos para:
     *
     * Generar el token: Usando una clave secreta y el nombre de usuario.
     *
     * Validar el token: Verificar que no haya expirado y que la firma sea correcta.
     *
     * Extraer el username: Para saber quién está haciendo la petición.
     */
    private String secretKey = "mi_clave_secreta_super_segura"; //usar una mas larga en producción
    private String userGenerator = "TuAppGyl";

    //GENERAR EL TOKEN
    public String generateToken(String username)
    {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        return JWT.create()
                .withIssuer(userGenerator)
                .withSubject(username)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 86400000))//24hs
                .sign(algorithm);
    }

    //VALIDAR Y DECODIFICAR EL TOKEN
    public DecodedJWT validateToken(String token)
    {
        try
        {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(userGenerator)
                    .build();

            return verifier.verify(token);
        }
        catch (JWTVerificationException exception)
        {
            //Token invalido o expirado
            return null;
        }
    }

    //Extraer el username  directamente del string del token
    public String getUsernameFromToken(String token)
    {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(userGenerator)
                .build();

        DecodedJWT decodedJWT = verifier.verify(token);

        return decodedJWT.getSubject();
    }
}
