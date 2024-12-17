package br.com.AulaJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmpresaDAO {
    private static final String PERSISTENCE_UNIT_NAME = "crud-basic";
    private static EntityManagerFactory factory;

    public EmpresaDAO() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public Empresa salvar(Empresa empresa) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(empresa);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
        return empresa;
    }

    public List<Empresa> listar() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Empresa> query = em.createQuery(
            "SELECT DISTINCT e FROM Empresa e LEFT JOIN FETCH e.plataformas LEFT JOIN FETCH e.categorias", Empresa.class
        );
        List<Empresa> empresas = query.getResultList();
        em.close();
        return empresas;
    }


    public Empresa buscarPorId(Long id) {
        EntityManager em = factory.createEntityManager();
        Empresa empresa = em.find(Empresa.class, id);
        em.close();
        return empresa;
    }

    public Empresa atualizar(Empresa empresa) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        empresa = em.merge(empresa);
        em.getTransaction().commit();
        em.close();
        return empresa;
    }

    public void deletar(Long id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Empresa empresa = em.find(Empresa.class, id);
        if (empresa != null) {
            em.remove(empresa);
        }
        em.getTransaction().commit();
        em.close();
    }
}
