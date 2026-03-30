
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class app {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("filme");

        EntityManager em = factory.createEntityManager();

        Filme filme = new Filme();
        
        filme.setTitulo("Interestelar");
        filme.setDiretor("Christopher Nolan");
        filme.setAnoLancamento(2014);
        filme.setGenero("Ficção Científica");
        filme.setDuracaoEmMinutos(169);
        filme.setSinopse("Em um futuro próximo");

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(filme);
        tx.commit();

        em.close();
        factory.close();
    }
}
