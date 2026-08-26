package com.example.aulajovem20262ia.controllers;

import com.example.aulajovem20262ia.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping
    public String ConsultaUsuario(){
        return "Hello Word!";
    }

    @GetMapping("/{id}")
    public Usuario ConsultaUsuarioPorId(@PathVariable Long id){
        Usuario usuario = new Usuario();

        usuario.setNome("Samuel");
        usuario.setCpf("063225155155");
        usuario.setDataNascimento("27/12/1993");
        return usuario;
    }

    @GetMapping("/empresa/{empresaId}")
    public Usuario ConsultaUsuarioPorEmpresa(@PathVariable Long empresaId){


        Usuario usuarioContrutorCompleto =
                new Usuario("Samuel","063720095945459","27/12/1193");
        return usuarioContrutorCompleto;
    }

    @PostMapping
    public ResponseEntity<Usuario> CadastrarUsuario(@RequestBody Usuario usuarioRequest){
        return ResponseEntity.ok(usuarioRequest);
    }




}
