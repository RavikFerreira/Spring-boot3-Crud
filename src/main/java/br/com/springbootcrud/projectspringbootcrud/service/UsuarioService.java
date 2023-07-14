package br.com.springbootcrud.projectspringbootcrud.service;

import br.com.springbootcrud.projectspringbootcrud.model.Usuario;
import br.com.springbootcrud.projectspringbootcrud.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        Usuario user = usuarioRepository.save(usuario);
        return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);

    }

    public ResponseEntity<String> delete(@RequestParam Long idUser){
        usuarioRepository.deleteById(idUser);
        return new ResponseEntity<String>("Usuário deletado com sucesso! ", HttpStatus.OK);
    }
    public ResponseEntity<Usuario> buscaruserid(@RequestParam("idUser") Long idUser){
        Usuario usuarios = usuarioRepository.findById(idUser).get();
        return new ResponseEntity<Usuario>(usuarios, HttpStatus.OK);
    }
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }
    public ResponseEntity<?> atualizar(@RequestBody Usuario usuario) throws ClassNotFoundException {
        if(usuario.getId() == null){
            return new ResponseEntity<String>("", HttpStatus.OK);
        }
        Usuario usuarios = usuarioRepository.saveAndFlush(usuario);
        return new ResponseEntity<Usuario>(usuarios, HttpStatus.OK);
    }

    public ResponseEntity<List<Usuario>> buscarpornome(@RequestParam(name = "name") String nome){
        List<Usuario> usuario = usuarioRepository.findByName(nome.trim().toUpperCase());
        return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
    }
}

