package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private KorisnikPK id;

	@Column(name="korisnicko_ime")
	private String korisnickoIme;

	private String sifra;

	//bi-directional many-to-one association to Osoba
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="osoba_id", referencedColumnName="id", insertable=false, updatable=false),
		})
	private Osoba osoba;

	public Korisnik() {
	}

	public KorisnikPK getId() {
		return this.id;
	}

	public void setId(KorisnikPK id) {
		this.id = id;
	}

	public String getKorisnickoIme() {
		return this.korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getSifra() {
		return this.sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

}