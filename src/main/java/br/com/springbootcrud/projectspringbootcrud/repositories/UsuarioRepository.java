package br.com.springbootcrud.projectspringbootcrud.repositories;

import br.com.springbootcrud.projectspringbootcrud.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "select u from Usuario u where upper(trim(u.nome)) like %?1%")
    List<Usuario> findByName(String nome);

}
