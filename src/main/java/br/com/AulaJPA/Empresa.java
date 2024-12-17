package br.com.AulaJPA;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Empresa")
public class Empresa {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column
    private String nome;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Plataforma> plataformas;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Categoria> categorias;


    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Set<Plataforma> getPlataformas() { return plataformas; }
    public void setPlataformas(Set<Plataforma> plataformas) { this.plataformas = plataformas; }
    public Set<Categoria> getCategorias() { return categorias; }
    public void setCategorias(Set<Categoria> categorias) { this.categorias = categorias; }
    
    @Override
    public String toString() {
        return this.nome;
    }
}
