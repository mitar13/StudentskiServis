package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="osoba_id")
	private int osobaId;

	private String hobi;

	private int index;

	private String sport;

	//bi-directional many-to-one association to Polaganje
	@OneToMany(mappedBy="student")
	private List<Polaganje> polaganjes;

	//bi-directional one-to-one association to Osoba
	@OneToOne
	@JoinColumns({
		@JoinColumn(name="osoba_id", referencedColumnName="id", insertable=false, updatable=false),
		})
	private Osoba osoba;

	public Student() {
	}

	public int getOsobaId() {
		return this.osobaId;
	}

	public void setOsobaId(int osobaId) {
		this.osobaId = osobaId;
	}

	public String getHobi() {
		return this.hobi;
	}

	public void setHobi(String hobi) {
		this.hobi = hobi;
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getSport() {
		return this.sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public List<Polaganje> getPolaganjes() {
		return this.polaganjes;
	}

	public void setPolaganjes(List<Polaganje> polaganjes) {
		this.polaganjes = polaganjes;
	}

	public Polaganje addPolaganje(Polaganje polaganje) {
		getPolaganjes().add(polaganje);
		polaganje.setStudent(this);

		return polaganje;
	}

	public Polaganje removePolaganje(Polaganje polaganje) {
		getPolaganjes().remove(polaganje);
		polaganje.setStudent(null);

		return polaganje;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

}