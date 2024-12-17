package br.com.AulaJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PlataformaDAO {
    private static final String PERSISTENCE_UNIT_NAME = "crud-basic";
    private static EntityManagerFactory factory;

    public PlataformaDAO() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public Plataforma salvar(Plataforma plataforma) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(plataforma);
        em.getTransaction().commit();
        em.close();
        return plataforma;
    }

    public List<Plataforma> listar() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Plataforma> query = em.createQuery("SELECT p FROM Plataforma p", Plataforma.class);
        List<Plataforma> plataformas = query.getResultList();
        em.close();
        return plataformas;
    }

    public Plataforma buscarPorId(Long id) {
        EntityManager em = factory.createEntityManager();
        Plataforma plataforma = em.find(Plataforma.class, id);
        em.close();
        return plataforma;
    }

    public Plataforma atualizar(Plataforma plataforma) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        plataforma = em.merge(plataforma);
        em.getTransaction().commit();
        em.close();
        return plataforma;
    }

    public void deletar(Long id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Plataforma plataforma = em.find(Plataforma.class, id);
        if (plataforma != null) {
            em.remove(plataforma);
        }
        em.getTransaction().commit();
        em.close();
    }
}
