package br.com.springbootcrud.projectspringbootcrud.controllers;

//import br.com.springbootcrud.projectspringbootcrud.model.Usuario;
//import br.com.springbootcrud.projectspringbootcrud.repositories.UsuarioRepository;
// org.springframework.beans.factory.annotation.Autowired;
import br.com.springbootcrud.projectspringbootcrud.model.Usuario;
import br.com.springbootcrud.projectspringbootcrud.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/listar todos")
    @ResponseBody
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);

    }
}

