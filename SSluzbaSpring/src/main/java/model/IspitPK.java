package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ispit database table.
 * 
 */
@Embeddable
public class IspitPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date vreme;

	@Column(name="predmet_id", insertable=false, updatable=false)
	private int predmetId;

	@Column(name="predmet_fakultet_id", insertable=false, updatable=false)
	private int predmetFakultetId;

	@Column(name="predmet_profesor_osoba_id", insertable=false, updatable=false)
	private int predmetProfesorOsobaId;

	public IspitPK() {
	}
	public java.util.Date getVreme() {
		return this.vreme;
	}
	public void setVreme(java.util.Date vreme) {
		this.vreme = vreme;
	}
	public int getPredmetId() {
		return this.predmetId;
	}
	public void setPredmetId(int predmetId) {
		this.predmetId = predmetId;
	}
	public int getPredmetFakultetId() {
		return this.predmetFakultetId;
	}
	public void setPredmetFakultetId(int predmetFakultetId) {
		this.predmetFakultetId = predmetFakultetId;
	}
	public int getPredmetProfesorOsobaId() {
		return this.predmetProfesorOsobaId;
	}
	public void setPredmetProfesorOsobaId(int predmetProfesorOsobaId) {
		this.predmetProfesorOsobaId = predmetProfesorOsobaId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IspitPK)) {
			return false;
		}
		IspitPK castOther = (IspitPK)other;
		return 
			this.vreme.equals(castOther.vreme)
			&& (this.predmetId == castOther.predmetId)
			&& (this.predmetFakultetId == castOther.predmetFakultetId)
			&& (this.predmetProfesorOsobaId == castOther.predmetProfesorOsobaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.vreme.hashCode();
		hash = hash * prime + this.predmetId;
		hash = hash * prime + this.predmetFakultetId;
		hash = hash * prime + this.predmetProfesorOsobaId;
		
		return hash;
	}
}