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
@Table(name="Action_A_Realiser")
public class ActionARealiser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "TYPE", length = 50)
	private String type;
	
	@Column(name = "CIBLE", length = 50)
	private String cible;
	
	@Column(name = "COORD_X", length = 4)
	private int coordX;
	
	@Column(name = "COORD_Y", length = 4)
	private int coordY;
	
	@ManyToOne
	@JoinColumn(name="ID_QUETE")
	Quete quete;
	
	public ActionARealiser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActionARealiser(String type, String cible, int coordX, int coordY) {
		super();
		this.type = type;
		this.cible = cible;
		this.coordX = coordX;
		this.coordY = coordY;
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

	/** Getter for type
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/** Setter for type
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/** Getter for cible
	 * @return the cible
	 */
	public String getCible() {
		return cible;
	}

	/** Setter for cible
	 * @param cible the cible to set
	 */
	public void setCible(String cible) {
		this.cible = cible;
	}

	/** Getter for coordX
	 * @return the coordX
	 */
	public int getCoordX() {
		return coordX;
	}

	/** Setter for coordX
	 * @param coordX the coordX to set
	 */
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	/** Getter for coordY
	 * @return the coordY
	 */
	public int getCoordY() {
		return coordY;
	}

	/** Setter for coordY
	 * @param coordY the coordY to set
	 */
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
	
}
