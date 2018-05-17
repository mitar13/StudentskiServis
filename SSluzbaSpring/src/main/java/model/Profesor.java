package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the profesor database table.
 * 
 */
@Entity
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="osoba_id")
	private int osobaId;

	private String seminar;

	//bi-directional many-to-one association to Predmet
	@OneToMany(mappedBy="profesor")
	private List<Predmet> predmets;

	//bi-directional one-to-one association to Osoba
	@OneToOne
	@JoinColumns({
		@JoinColumn(name="osoba_id", referencedColumnName="id", insertable=false, updatable=false),
		})
	private Osoba osoba;

	public Profesor() {
	}

	public int getOsobaId() {
		return this.osobaId;
	}

	public void setOsobaId(int osobaId) {
		this.osobaId = osobaId;
	}

	public String getSeminar() {
		return this.seminar;
	}

	public void setSeminar(String seminar) {
		this.seminar = seminar;
	}

	public List<Predmet> getPredmets() {
		return this.predmets;
	}

	public void setPredmets(List<Predmet> predmets) {
		this.predmets = predmets;
	}

	public Predmet addPredmet(Predmet predmet) {
		getPredmets().add(predmet);
		predmet.setProfesor(this);

		return predmet;
	}

	public Predmet removePredmet(Predmet predmet) {
		getPredmets().remove(predmet);
		predmet.setProfesor(null);

		return predmet;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

}