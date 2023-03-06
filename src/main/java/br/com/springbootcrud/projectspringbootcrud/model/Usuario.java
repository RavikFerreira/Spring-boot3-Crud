package br.com.springbootcrud.projectspringbootcrud.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tb_usuarios")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Idade")
    private int idade;

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
