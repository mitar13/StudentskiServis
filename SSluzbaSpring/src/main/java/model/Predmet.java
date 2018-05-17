package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the predmet database table.
 * 
 */
@Entity
@NamedQuery(name="Predmet.findAll", query="SELECT p FROM Predmet p")
public class Predmet implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PredmetPK id;

	@Column(name="broj_espb")
	private int brojEspb;

	private String naziv;

	//bi-directional many-to-one association to Ispit
	@OneToMany(mappedBy="predmet")
	private List<Ispit> ispits;

	//bi-directional many-to-one association to Fakultet
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="fakultet_id", referencedColumnName="id", insertable=false, updatable=false),
		})
	private Fakultet fakultet;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="profesor_osoba_id", referencedColumnName="osoba_id", insertable=false, updatable=false),
		})
	private Profesor profesor;

	public Predmet() {
	}

	public PredmetPK getId() {
		return this.id;
	}

	public void setId(PredmetPK id) {
		this.id = id;
	}

	public int getBrojEspb() {
		return this.brojEspb;
	}

	public void setBrojEspb(int brojEspb) {
		this.brojEspb = brojEspb;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Ispit> getIspits() {
		return this.ispits;
	}

	public void setIspits(List<Ispit> ispits) {
		this.ispits = ispits;
	}

	public Ispit addIspit(Ispit ispit) {
		getIspits().add(ispit);
		ispit.setPredmet(this);

		return ispit;
	}

	public Ispit removeIspit(Ispit ispit) {
		getIspits().remove(ispit);
		ispit.setPredmet(null);

		return ispit;
	}

	public Fakultet getFakultet() {
		return this.fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}