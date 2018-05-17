package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fakultet database table.
 * 
 */
@Entity
@NamedQuery(name="Fakultet.findAll", query="SELECT f FROM Fakultet f")
public class Fakultet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String naziv;

	private String skracenica;

	//bi-directional many-to-one association to Predmet
	@OneToMany(mappedBy="fakultet")
	private List<Predmet> predmets;

	public Fakultet() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkracenica() {
		return this.skracenica;
	}

	public void setSkracenica(String skracenica) {
		this.skracenica = skracenica;
	}

	public List<Predmet> getPredmets() {
		return this.predmets;
	}

	public void setPredmets(List<Predmet> predmets) {
		this.predmets = predmets;
	}

	public Predmet addPredmet(Predmet predmet) {
		getPredmets().add(predmet);
		predmet.setFakultet(this);

		return predmet;
	}

	public Predmet removePredmet(Predmet predmet) {
		getPredmets().remove(predmet);
		predmet.setFakultet(null);

		return predmet;
	}

}