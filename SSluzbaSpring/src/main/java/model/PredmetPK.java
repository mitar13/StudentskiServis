package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the predmet database table.
 * 
 */
@Embeddable
public class PredmetPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="fakultet_id", insertable=false, updatable=false)
	private int fakultetId;

	@Column(name="profesor_osoba_id", insertable=false, updatable=false)
	private int profesorOsobaId;

	public PredmetPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFakultetId() {
		return this.fakultetId;
	}
	public void setFakultetId(int fakultetId) {
		this.fakultetId = fakultetId;
	}
	public int getProfesorOsobaId() {
		return this.profesorOsobaId;
	}
	public void setProfesorOsobaId(int profesorOsobaId) {
		this.profesorOsobaId = profesorOsobaId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PredmetPK)) {
			return false;
		}
		PredmetPK castOther = (PredmetPK)other;
		return 
			(this.id == castOther.id)
			&& (this.fakultetId == castOther.fakultetId)
			&& (this.profesorOsobaId == castOther.profesorOsobaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.fakultetId;
		hash = hash * prime + this.profesorOsobaId;
		
		return hash;
	}
}