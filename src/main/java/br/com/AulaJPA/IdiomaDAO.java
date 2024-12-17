package br.com.AulaJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class IdiomaDAO {
	
    private static final String PERSISTENCE_UNIT_NAME = "crud-basic";
    private static EntityManagerFactory factory;

    public IdiomaDAO() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public Idioma salvar(Idioma idioma) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(idioma);
        em.getTransaction().commit();
        em.close();
        return idioma;
    }

    public List<Idioma> listar() {
        EntityManager em = factory.createEntityManager();
        // Corrigido: consulta agora retorna Idioma
        TypedQuery<Idioma> query = em.createQuery("SELECT i FROM Idioma i", Idioma.class);
        List<Idioma> idiomas = query.getResultList();
        em.close();
        return idiomas;
    }

    public Idioma buscarPorId(Long id) {
        EntityManager em = factory.createEntityManager();
        Idioma idioma = em.find(Idioma.class, id);
        em.close();
        return idioma;
    }

    public Idioma atualizar(Idioma idioma) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        idioma = em.merge(idioma);
        em.getTransaction().commit();
        em.close();
        return idioma;
    }

    public void deletar(Long id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Idioma idioma = em.find(Idioma.class, id);
        if (idioma != null) {
            em.remove(idioma);
        }
        em.getTransaction().commit();
        em.close();
    }

    // Corrigido: agora retorna uma lista de Idiomas de um usuário
    public List<Idioma> listarIdiomasDoUsuario(Long usuarioId) {
        EntityManager em = factory.createEntityManager();
        // A consulta agora busca os idiomas a partir dos jogos do usuário
        TypedQuery<Idioma> query = em.createQuery(
            "SELECT i FROM Idioma i WHERE i.jogo.usuario.id = :usuarioId", Idioma.class);
        query.setParameter("usuarioId", usuarioId);
        List<Idioma> idiomas = query.getResultList();
        em.close();
        return idiomas;
    }
}
