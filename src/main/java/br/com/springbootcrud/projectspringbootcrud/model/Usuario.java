package br.com.springbootcrud.projectspringbootcrud.model;

import jakarta.persistence.*;
import java.io.Serializable;
@Entity
@SequenceGenerator(name = "seq_usuario",sequenceName = "seq_usuario", allocationSize = 1,initialValue = 1)
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private Long id;
    private String nome;
    private int idade;

    public Usuario(Long id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Usuario() {
    }

    public Usuario(String string, int i) {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
