package br.com.springbootcrud.projectspringbootcrud.controllers;

import br.com.springbootcrud.projectspringbootcrud.model.Usuario;
import br.com.springbootcrud.projectspringbootcrud.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listartodos")
    @ResponseBody
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }
    @PostMapping (value = "salvar")
    @ResponseBody
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        return usuarioService.salvar(usuario);

    }
    @DeleteMapping("delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idUser){
        return usuarioService.delete(idUser);
    }
    @GetMapping("buscaruserid")
    @ResponseBody
    public ResponseEntity<Usuario> buscaruserid(@RequestParam("idUser") Long idUser){
        return usuarioService.buscaruserid(idUser);
    }

    @PutMapping("atualizar")
    @ResponseBody
    public ResponseEntity<?> atualizar(@RequestBody Usuario usuario) throws ClassNotFoundException {
        return usuarioService.atualizar(usuario);
    }
    @GetMapping("buscarpornome")
    @ResponseBody
     public ResponseEntity<List<Usuario>> buscarpornome(@RequestParam(name = "name") String nome){
        return usuarioService.buscarpornome(nome.trim().toUpperCase());

     }
}

