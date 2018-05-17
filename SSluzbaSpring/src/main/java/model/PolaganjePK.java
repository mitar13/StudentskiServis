package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the polaganje database table.
 * 
 */
@Embeddable
public class PolaganjePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="student_osoba_id", insertable=false, updatable=false)
	private int studentOsobaId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ispit_vreme", insertable=false, updatable=false)
	private java.util.Date ispitVreme;

	@Column(name="ispit_predmet_id", insertable=false, updatable=false)
	private int ispitPredmetId;

	@Column(name="ispit_predmet_fakultet_id", insertable=false, updatable=false)
	private int ispitPredmetFakultetId;

	@Column(name="ispit_predmet_profesor_osoba_id", insertable=false, updatable=false)
	private int ispitPredmetProfesorOsobaId;

	public PolaganjePK() {
	}
	public int getStudentOsobaId() {
		return this.studentOsobaId;
	}
	public void setStudentOsobaId(int studentOsobaId) {
		this.studentOsobaId = studentOsobaId;
	}
	public java.util.Date getIspitVreme() {
		return this.ispitVreme;
	}
	public void setIspitVreme(java.util.Date ispitVreme) {
		this.ispitVreme = ispitVreme;
	}
	public int getIspitPredmetId() {
		return this.ispitPredmetId;
	}
	public void setIspitPredmetId(int ispitPredmetId) {
		this.ispitPredmetId = ispitPredmetId;
	}
	public int getIspitPredmetFakultetId() {
		return this.ispitPredmetFakultetId;
	}
	public void setIspitPredmetFakultetId(int ispitPredmetFakultetId) {
		this.ispitPredmetFakultetId = ispitPredmetFakultetId;
	}
	public int getIspitPredmetProfesorOsobaId() {
		return this.ispitPredmetProfesorOsobaId;
	}
	public void setIspitPredmetProfesorOsobaId(int ispitPredmetProfesorOsobaId) {
		this.ispitPredmetProfesorOsobaId = ispitPredmetProfesorOsobaId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PolaganjePK)) {
			return false;
		}
		PolaganjePK castOther = (PolaganjePK)other;
		return 
			(this.studentOsobaId == castOther.studentOsobaId)
			&& this.ispitVreme.equals(castOther.ispitVreme)
			&& (this.ispitPredmetId == castOther.ispitPredmetId)
			&& (this.ispitPredmetFakultetId == castOther.ispitPredmetFakultetId)
			&& (this.ispitPredmetProfesorOsobaId == castOther.ispitPredmetProfesorOsobaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.studentOsobaId;
		hash = hash * prime + this.ispitVreme.hashCode();
		hash = hash * prime + this.ispitPredmetId;
		hash = hash * prime + this.ispitPredmetFakultetId;
		hash = hash * prime + this.ispitPredmetProfesorOsobaId;
		
		return hash;
	}
}