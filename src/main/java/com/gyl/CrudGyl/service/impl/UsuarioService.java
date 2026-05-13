package com.gyl.CrudGyl.service.impl;

import com.gyl.CrudGyl.entity.Usuario;
import com.gyl.CrudGyl.repository.IUserRepository;
import com.gyl.CrudGyl.service.interf.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService
{
    private final IUserRepository iUserRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario registrar(Usuario usuario)
    {
        //Encriptamos contraseña
        String passwordEncriptada = passwordEncoder.encode(usuario.getPassword());

        //seteamos de nuevo el objeto
        usuario.setPassword(passwordEncriptada);

        //Guardamos en la base de datos
        return iUserRepository.save(usuario);
    }
}
