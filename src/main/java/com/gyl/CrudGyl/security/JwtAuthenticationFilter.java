package com.gyl.CrudGyl.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.gyl.CrudGyl.service.impl.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * OncePerRequestFilter: Su trabajo es interceptar cada petición que
 * llega al servidor.
 */

/**
 * El flujo del filtro es:
 *
 * Extrae el header Authorization.
 *
 * Verifica si empieza con Bearer .
 *
 * Si es válido, extrae el JWT, lo valida y busca al usuario en la base de datos.
 *
 * Establece la autenticación en el SecurityContextHolder.
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter
{
    private JwtUtils jwtUtils;
    private UserDetailsServiceImpl userDetailsService;

    public JwtAuthenticationFilter(JwtUtils jwtUtils, UserDetailsServiceImpl userDetailsService) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal
            (
                    HttpServletRequest request,
                    HttpServletResponse response,
                    FilterChain filterChain
            ) throws ServletException, IOException
    {
        //1. OBTENER EL HEADER "AUTHORIZATION"
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer "))
        {
            String token = authHeader.substring(7);

            //Validar el token
            DecodedJWT decodedJWT = jwtUtils.validateToken(token);

            if (decodedJWT != null)
            {
                //si es valido, obtener el usuario
                String username = jwtUtils.getUsernameFromToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                //Meter al usuario en el contexto de seguridad de Spring
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken
                                (
                                        username,
                                        null,
                                        userDetails.getAuthorities()
                                );
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        //Continuar con la cadena de filtros
        filterChain.doFilter(request, response);
    }
}
