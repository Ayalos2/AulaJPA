package br.com.AulaJPA;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JogoDAO {

	    private static final String PERSISTENCE_UNIT_NAME = "crud-basic";
	    private static EntityManagerFactory factory;

	    public JogoDAO() {
	        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    }

	    public Jogo salvar(Jogo jogo) {
	        EntityManager em = factory.createEntityManager();
	        em.getTransaction().begin();
	        em.persist(jogo);
	        em.getTransaction().commit();
	        em.close();
	        return jogo;
	    }

	    public List<Jogo> listar() {
	        EntityManager em = factory.createEntityManager();
	        TypedQuery<Jogo> query = em.createQuery("SELECT u FROM Jogo u", Jogo.class);
	        List<Jogo> jogos = query.getResultList();
	        em.close();
	        return jogos;
	    }

	    public Jogo buscarPorId(Long id) {
	        EntityManager em = factory.createEntityManager();
	        Jogo jogo = em.find(Jogo.class, id);
	        em.close();
	        return jogo;
	    }
	    
	    public Jogo buscaIdioma(Long id) {
	        EntityManager em = factory.createEntityManager();
	        TypedQuery<Jogo> query = em.createQuery("SELECT j FROM Jogo j LEFT JOIN FETCH j.idioma WHERE j.id = :id", Jogo.class);
	        query.setParameter("id", id);	  
	        Jogo jogo = query.getSingleResult();
	        em.close();
	        return jogo;
	    }

	    public Jogo atualizar(Jogo jogo) {
	        EntityManager em = factory.createEntityManager();
	        em.getTransaction().begin();
	        jogo = em.merge(jogo);
	        em.getTransaction().commit();
	        em.close();
	        return jogo;
	    }

	    public void deletar(Long id) {
	        EntityManager em = factory.createEntityManager();
	        em.getTransaction().begin();
	        Jogo jogo = em.find(Jogo.class, id);
	        if (jogo != null) {
	            em.remove(jogo);
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
	
	
	
	
	
	
	
	
	
	
	
