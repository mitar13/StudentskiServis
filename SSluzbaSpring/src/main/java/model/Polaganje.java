package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the polaganje database table.
 * 
 */
@Entity
@NamedQuery(name="Polaganje.findAll", query="SELECT p FROM Polaganje p")
public class Polaganje implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PolaganjePK id;

	private int ocena;

	//bi-directional many-to-one association to Ispit
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ispit_predmet_fakultet_id", referencedColumnName="predmet_fakultet_id", insertable=false, updatable=false),
		@JoinColumn(name="ispit_predmet_id", referencedColumnName="predmet_id", insertable=false, updatable=false),
		@JoinColumn(name="ispit_predmet_profesor_osoba_id", referencedColumnName="predmet_profesor_osoba_id", insertable=false, updatable=false),
		@JoinColumn(name="ispit_vreme", referencedColumnName="vreme", insertable=false, updatable=false)
		})
	private Ispit ispit;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="student_osoba_id", referencedColumnName="osoba_id", insertable=false, updatable=false),
		})
	private Student student;

	//bi-directional many-to-one association to Student
//	@ManyToOne
	//private Student student;

	public Polaganje() {
	}

	public PolaganjePK getId() {
		return this.id;
	}

	public void setId(PolaganjePK id) {
		this.id = id;
	}

	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Ispit getIspit() {
		return this.ispit;
	}

	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}