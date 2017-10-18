package dev.jeu_de_role_JPA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Caracteristique")
public class Caracteristique {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOM", length = 50)
	private String nom;
	
	@Column(name = "VALEUR", length = 50)
	private int valeur;

	public Caracteristique() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Caracteristique(String nom, int valeur) {
		super();
		this.nom = nom;
		this.valeur = valeur;
	}
	
	public Caracteristique(Integer id, String nom, int valeur) {
		this(nom, valeur);
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
	/** Getter for valeur
	 * @return the valeur
	 */
	public int getValeur() {
		return valeur;
	}
	/** Setter for valeur
	 * @param valeur the valeur to set
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
		
}
