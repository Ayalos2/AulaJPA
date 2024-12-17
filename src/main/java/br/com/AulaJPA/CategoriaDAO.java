package br.com.AulaJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoriaDAO {
    private static final String PERSISTENCE_UNIT_NAME = "crud-basic";
    private static EntityManagerFactory factory;

    public CategoriaDAO() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public Categoria salvar(Categoria categoria) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();
        em.close();
        return categoria;
    }

    public List<Categoria> listar() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Categoria> query = em.createQuery("SELECT c FROM Categoria c", Categoria.class);
        List<Categoria> categorias = query.getResultList();
        em.close();
        return categorias;
    }

    public Categoria buscarPorId(Long id) {
        EntityManager em = factory.createEntityManager();
        Categoria categoria = em.find(Categoria.class, id);
        em.close();
        return categoria;
    }

    public Categoria atualizar(Categoria categoria) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            
            // O merge garante que a categoria será atualizada se já estiver persistida
            categoria = em.merge(categoria);
            
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
        return categoria;
    }


    public void deletar(Long id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Categoria categoria = em.find(Categoria.class, id);
        if (categoria != null) {
            em.remove(categoria);
        }
        em.getTransaction().commit();
        em.close();
    }
}
