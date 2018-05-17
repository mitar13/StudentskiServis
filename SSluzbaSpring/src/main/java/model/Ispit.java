package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ispit database table.
 * 
 */
@Entity
@NamedQuery(name="Ispit.findAll", query="SELECT i FROM Ispit i")
public class Ispit implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IspitPK id;

	private String amfiteatar;

	//bi-directional many-to-one association to Predmet
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="predmet_fakultet_id", referencedColumnName="fakultet_id", insertable=false, updatable=false),
		@JoinColumn(name="predmet_id", referencedColumnName="id", insertable=false, updatable=false),
		@JoinColumn(name="predmet_profesor_osoba_id", referencedColumnName="profesor_osoba_id", insertable=false, updatable=false)
		})
	private Predmet predmet;

	//bi-directional many-to-one association to Polaganje
	@OneToMany(mappedBy="ispit")
	private List<Polaganje> polaganjes;

	public Ispit() {
	}

	public IspitPK getId() {
		return this.id;
	}

	public void setId(IspitPK id) {
		this.id = id;
	}

	public String getAmfiteatar() {
		return this.amfiteatar;
	}

	public void setAmfiteatar(String amfiteatar) {
		this.amfiteatar = amfiteatar;
	}

	public Predmet getPredmet() {
		return this.predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public List<Polaganje> getPolaganjes() {
		return this.polaganjes;
	}

	public void setPolaganjes(List<Polaganje> polaganjes) {
		this.polaganjes = polaganjes;
	}

	public Polaganje addPolaganje(Polaganje polaganje) {
		getPolaganjes().add(polaganje);
		polaganje.setIspit(this);

		return polaganje;
	}

	public Polaganje removePolaganje(Polaganje polaganje) {
		getPolaganjes().remove(polaganje);
		polaganje.setIspit(null);

		return polaganje;
	}

}