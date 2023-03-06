package br.com.springbootcrud.projectspringbootcrud.controllers;

//import br.com.springbootcrud.projectspringbootcrud.model.Usuario;
//import br.com.springbootcrud.projectspringbootcrud.repositories.UsuarioRepository;
// org.springframework.beans.factory.annotation.Autowired;
import br.com.springbootcrud.projectspringbootcrud.model.Usuario;
import br.com.springbootcrud.projectspringbootcrud.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/all")
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }
    //}

}
