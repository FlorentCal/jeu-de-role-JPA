package dev.jeu_de_role_JPA;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Quete")
public class Quete {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOM", length = 50)
	private String nom;
	
	@Column(name = "DELAI", length = 4)
	private int delai;
	
	@Column(name = "DEBUT_COORD_X", length = 4)
	private int debutCoordX;
	
	@Column(name = "DEBUT_COORD_Y", length = 4)
	private int debutCoordY;
	
	@OneToMany(mappedBy = "quete")
	private Set<ActionARealiser> actionsARealiser;
	
	public Quete() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quete(String nom, int delai, int debutCoordX, int debutCoordY) {
		super();
		this.nom = nom;
		this.delai = delai;
		this.debutCoordX = debutCoordX;
		this.debutCoordY = debutCoordY;
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
	/** Getter for delai
	 * @return the delai
	 */
	public int getDelai() {
		return delai;
	}
	/** Setter for delai
	 * @param delai the delai to set
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}
	/** Getter for debutCoordX
	 * @return the debutCoordX
	 */
	public int getDebutCoordX() {
		return debutCoordX;
	}
	/** Setter for debutCoordX
	 * @param debutCoordX the debutCoordX to set
	 */
	public void setDebutCoordX(int debutCoordX) {
		this.debutCoordX = debutCoordX;
	}
	/** Getter for debutCoordY
	 * @return the debutCoordY
	 */
	public int getDebutCoordY() {
		return debutCoordY;
	}
	/** Setter for debutCoordY
	 * @param debutCoordY the debutCoordY to set
	 */
	public void setDebutCoordY(int debutCoordY) {
		this.debutCoordY = debutCoordY;
	}
	
	
}
