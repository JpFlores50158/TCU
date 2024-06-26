package com.TCU.dao;

import com.TCU.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    
    Usuario findByUsername(String username);
    
    Usuario findByUsernameAndPassword(String username, String password);

    Usuario findByUsernameOrCorreo(String username, String correo);

    boolean existsByUsernameOrCorreo(String username, String correo);
    
   @Query("SELECT u FROM Usuario u WHERE u.idUsuario <> :idUsuario")
    List<Usuario> findAllByIdUsuarioNot(@Param("idUsuario") Long idUsuario);
    
    
}
