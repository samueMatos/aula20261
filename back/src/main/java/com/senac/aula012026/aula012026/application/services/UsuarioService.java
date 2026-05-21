package com.senac.aula012026.aula012026.application.services;

import com.senac.aula012026.aula012026.application.DTO.LoginRequest;
import com.senac.aula012026.aula012026.application.DTO.UsuarioAdmRequest;
import com.senac.aula012026.aula012026.application.DTO.UsuarioRequest;
import com.senac.aula012026.aula012026.application.DTO.UsuarioResponse;
import com.senac.aula012026.aula012026.domain.entities.Usuario;
import com.senac.aula012026.aula012026.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Value("${spring.secretkey}")
    private String secret;


    public boolean ValidaUsuarioSenha(LoginRequest loginRequest) {
        try {

            return usuarioRepository.existsUsuarioByEmailContainingAndSenha(loginRequest.email(), loginRequest.senha());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<UsuarioResponse> ListarTodos() {
        try{
            return usuarioRepository.findAll()
                    .stream()
                    .map(UsuarioResponse::new)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario BuscarUsuarioLogado(Usuario usuario) {

        try{
            return   usuarioRepository.findById(usuario.getId()).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public UsuarioResponse BuscarUsuarioPorId(Long id) {
        try{
           var usuario = usuarioRepository.findById(id).orElse(null);
           return new UsuarioResponse(usuario);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public boolean AterarUsuario(Long id, UsuarioRequest usuario) {

        var usuarioBanco = usuarioRepository.findById(id).orElse(null);

        if (usuarioBanco != null){
            usuarioBanco.setEmail(usuario.email());
            usuarioBanco.setNome(usuario.nome());
            usuarioBanco.setSenha(usuario.senha());


            usuarioRepository.save(usuarioBanco);

            return true;
        }

        return false;
    }

    public Long SalvarUsuario(UsuarioRequest usuario) {
        try {
            return usuarioRepository.save(new Usuario(usuario)).getId();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public Long SalvarUsuarioAdm(UsuarioAdmRequest usuario) {
        try {

            if(usuario.secretKey().equals( secret)) {
                return usuarioRepository.save(new Usuario(usuario)).getId();
            }else
            {
                return 0L;
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
