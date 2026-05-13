package com.gyl.CrudGyl.mapper;

import com.gyl.CrudGyl.dto.response.RegistroResponseDto;
import com.gyl.CrudGyl.dto.resquest.RegistroRequestDto;
import com.gyl.CrudGyl.entity.Usuario;
import com.gyl.CrudGyl.enumP.Rol;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsuarioMapper
{
    public static Usuario toEntity(RegistroRequestDto dto, PasswordEncoder passwordEncoder)
    {
        Usuario usuario = new Usuario();

        usuario.setUsername(dto.username());
        usuario.setPassword(passwordEncoder.encode(dto.password()));

        usuario.setRole(Rol.USER);

        return usuario;
    }
}
