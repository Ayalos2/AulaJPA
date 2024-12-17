package br.com.AulaJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UsuarioDAO {

    private static final String PERSISTENCE_UNIT_NAME = "crud-basic";
    private static EntityManagerFactory factory;

    public UsuarioDAO() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public Usuario salvar(Usuario usuario) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
        return usuario;
    }

    public List<Usuario> listar() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u LEFT JOIN FETCH u.jogos j LEFT JOIN FETCH j.idiomas", Usuario.class);
        List<Usuario> usuarios = query.getResultList();
        em.close();
        return usuarios;
    }

    public Usuario buscarPorId(Long id) {
        EntityManager em = factory.createEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        return usuario;
    }

    public Usuario atualizar(Usuario usuario) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        usuario = em.merge(usuario);
        em.getTransaction().commit();
        em.close();
        return usuario;
    }

    public void deletar(Long id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, id);
        if (usuario != null) {
            em.remove(usuario);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Jogo> listarJogosDoUsuario(Long usuarioId) {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Jogo> query = em.createQuery("SELECT j FROM Jogo j WHERE j.usuario.id = :usuarioId", Jogo.class);
        query.setParameter("usuarioId", usuarioId);
        List<Jogo> jogos = query.getResultList();
        em.close();
        return jogos;
    }
}
