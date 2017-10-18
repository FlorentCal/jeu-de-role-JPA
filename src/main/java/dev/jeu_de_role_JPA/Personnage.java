package dev.jeu_de_role_JPA;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Personnage")
public class Personnage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOM", length = 50)
	private String nom;
	@Column(name = "PRENOM", length = 50)
	private String prenom;
	
	@Column(name = "AGE", length = 3)
	private int age;
	
	@ManyToMany
	@JoinTable(name="PERS_CAR", 
		joinColumns=
			@JoinColumn(name="ID_PERSONNAGE", referencedColumnName="ID"), 	
		inverseJoinColumns=
			@JoinColumn(name="ID_CAR", referencedColumnName="ID")
	)
	private Set<Caracteristique> caracteristiques;
	
	@ManyToOne
	@JoinColumn(name="ID_CLASSE")
	Classe classe;
	
	@ManyToOne
	@JoinColumn(name="ID_SCENARIO")
	Scenario scenario;	
		
	public Personnage(String nom, String prenom, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
		
	public Personnage(Integer id, String nom, String prenom, int age) {
		this(nom, prenom, age);
		this.id = id;
	}



	/** Getter for id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/** Setter for id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public Personnage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** Getter for nom
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter for nom
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter for prenom
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Setter for prenom
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Getter for age
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/** Setter for age
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/** Getter for classe
	 * @return the classe
	 */
	public Classe getClasse() {
		return classe;
	}

	/** Setter for classe
	 * @param classe the classe to set
	 */
	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	/** Getter for caracteristiques
	 * @return the caracteristiques
	 */
	public Set<Caracteristique> getCaracteristiques() {
		return caracteristiques;
	}


	/** Setter for caracteristiques
	 * @param caracteristiques the caracteristiques to set
	 */
	public void setCaracteristiques(Set<Caracteristique> caracteristiques) {
		this.caracteristiques = caracteristiques;
	}
	
	
	
}
