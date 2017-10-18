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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Scenario")
public class Scenario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOM", length = 50)
	private String nom;

	@OneToMany(mappedBy = "scenario")
	private Set<Personnage> personnages;
	
	@ManyToMany
	@JoinTable(name="COMPO", 
		joinColumns=
			@JoinColumn(name="ID_SCENARIO", referencedColumnName="ID"), 	
		inverseJoinColumns=
			@JoinColumn(name="ID_QUETE", referencedColumnName="ID")
	)
	private Set<Quete> quetes;
	
	public Scenario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Scenario(String nom) {
		super();
		this.nom = nom;
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
	
	
	
}
