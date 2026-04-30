package com.senac.aula012026.aula012026.domain.repository;

import com.senac.aula012026.aula012026.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

     boolean existsUsuarioByEmailContainingAndSenha(String email, String senha);
}
