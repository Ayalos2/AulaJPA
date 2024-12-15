package br.com.AulaJPA;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Jogo> jogos;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Jogo> getJogos() { return jogos; }
    public void setJogos(List<Jogo> jogos) { this.jogos = jogos; }

    @Override
    public String toString() {
        return this.nome;
    }
}
