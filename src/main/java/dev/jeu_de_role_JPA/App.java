package dev.jeu_de_role_JPA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Hello world!
 *
 */
public class App 
{
	static EntityManagerFactory entityManagerFactory;
    public static void main( String[] args )
    {
       
    	entityManagerFactory = Persistence.createEntityManagerFactory("jdr");
		EntityManager em = entityManagerFactory.createEntityManager();

		initializeDatabase();
		
		annotation(em);
		
		
		em.close();
		entityManagerFactory.close();
    }
    
    private static void annotation(EntityManager em) {
		Query query = em.createQuery("select p from Personnage p");
		List<Personnage> personnages = query.getResultList();
		
		for (Personnage personnage : personnages) {
			System.out.println(personnage.toString());
			for (Caracteristique caracteristique : personnage.getCaracteristiques()) {
				System.out.println("\t" + caracteristique.toString());
			}
		}

	}
    
    private static void initializeDatabase(){
    	
    	List<Personnage> personnages = new ArrayList<Personnage>();
    	Set<Caracteristique> caracteristiquesP1 = new HashSet<>();
    	Set<Caracteristique> caracteristiquesP2 = new HashSet<>();
    	Set<Caracteristique> caracteristiquesP3 = new HashSet<>();
    	
    	Personnage p1 = new Personnage("Callaou", "Florent", 21);
    	Personnage p2 = new Personnage("LeHennaf", "Olivier", 28);
    	Personnage p3 = new Personnage("Cavaille", "Nicolas", 22);
    	
    	Caracteristique c1 = new Caracteristique("TestCarP1", 12);
    	Caracteristique c2 = new Caracteristique("TestCar2P1", 51);
    	
    	Caracteristique c3 = new Caracteristique("TestCarP2", 22);
    	Caracteristique c4 = new Caracteristique("TestCar2P2", 81);
    	Caracteristique c5 = new Caracteristique("TestCar3P2", 53);
    	
    	Caracteristique c6 = new Caracteristique("TestCarP3", 72);
    	
    	Classe classe1 = new Classe("Paladin");
    	Classe classe2 = new Classe("Nain");
    	
    	caracteristiquesP1.add(c1);
    	caracteristiquesP1.add(c2);
    	p1.setCaracteristiques(caracteristiquesP1);
    	
       	caracteristiquesP2.add(c3);
    	caracteristiquesP2.add(c4);
    	caracteristiquesP2.add(c5);
    	p2.setCaracteristiques(caracteristiquesP2);
    	
    	caracteristiquesP3.add(c6);
    	p3.setCaracteristiques(caracteristiquesP3);
    	
    	p1.setClasse(classe1);
    	p2.setClasse(classe1);
    	p3.setClasse(classe2);
    	
    	personnages.add(p1);
    	personnages.add(p2);
    	personnages.add(p3);
    	    	    	
    	insert(classe1, "select c from Classe c where c.nom = '" + classe1.getNom() + "'");
    	insert(classe2, "select c from Classe c where c.nom = '" + classe2.getNom() + "'");
    	
    	caracteristiquesP1.forEach(cOne -> insert(cOne, "select c from Caracteristique c where c.nom = '"+ cOne.getNom() + "'"));
    	caracteristiquesP2.forEach(cTwo -> insert(cTwo, "select c from Caracteristique c where c.nom = '"+ cTwo.getNom() + "'"));
    	caracteristiquesP3.forEach(cThree -> insert(cThree, "select c from Caracteristique c where c.nom = '"+ cThree.getNom() + "'"));
    	personnages.forEach(p -> insert(p, "select p from Personnage p where p.nom = '"+ p.getNom() + "'"));   
    	
    	
    }
    
    private static <T> void insert(T element, String query){
    	Optional<T> elementFound = findAnythingyBy(query);
		
		if(!elementFound.isPresent()){
			executeTransaction(em -> em.persist(element));
		} 
    }
    
    public static <T extends Object> Optional<T> findAnythingyBy(String query) {
		T anything = null;
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Query queryTest = entityManager.createQuery(query);
		if(!queryTest.getResultList().isEmpty()){
			anything = (T) queryTest.getResultList().get(0);
		}	
		
		entityManager.close();

		return Optional.ofNullable(anything);
	}
    
    public static void executeTransaction(Consumer<EntityManager> consumer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		consumer.accept(entityManager);

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
