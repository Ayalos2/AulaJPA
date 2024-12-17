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
		        TypedQuery<Idioma> query = em.createQuery("SELECT u FROM Usuario u", Idioma.class);
		        List<Idioma> usuarios = query.getResultList();
		        em.close();
		        return usuarios;
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

		    public List<Idioma> listarJogosDoUsuario(Long usuarioId) {
		        EntityManager em = factory.createEntityManager();
		        TypedQuery<Idioma> query = em.createQuery("SELECT j FROM Jogo j WHERE j.usuario.id = :usuarioId", Idioma.class);
		        query.setParameter("usuarioId", usuarioId);
		        List<Idioma> idioma= query.getResultList();
		        em.close();
		        return idioma;
		    }
		}
		
		
		
		
		
		
		
		
		
		
		


	
	
	
	
	
	

