package br.com.AulaJPA;

import javax.persistence.*;

@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String genero;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    @Override
    public String toString() {
        return this.nome;
    }
}
