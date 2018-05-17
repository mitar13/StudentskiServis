package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the osoba database table.
 * 
 */
@Entity
@NamedQuery(name="Osoba.findAll", query="SELECT o FROM Osoba o")
public class Osoba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="god_rodjenja")
	private Date godRodjenja;

	private String ime;

	private String mesto;

	private String pol;

	@Column(name="postanski_br")
	private int postanskiBr;

	private String prezime;

	//bi-directional many-to-one association to Korisnik
	@OneToMany(mappedBy="osoba")
	private List<Korisnik> korisniks;

	//bi-directional one-to-one association to Profesor
	@OneToOne(mappedBy="osoba")
	private Profesor profesor;

	//bi-directional one-to-one association to Student
	@OneToOne(mappedBy="osoba")
	private Student student;

	public Osoba() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getGodRodjenja() {
		return this.godRodjenja;
	}

	public void setGodRodjenja(Date godRodjenja) {
		this.godRodjenja = godRodjenja;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getMesto() {
		return this.mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getPol() {
		return this.pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public int getPostanskiBr() {
		return this.postanskiBr;
	}

	public void setPostanskiBr(int postanskiBr) {
		this.postanskiBr = postanskiBr;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Korisnik> getKorisniks() {
		return this.korisniks;
	}

	public void setKorisniks(List<Korisnik> korisniks) {
		this.korisniks = korisniks;
	}

	public Korisnik addKorisnik(Korisnik korisnik) {
		getKorisniks().add(korisnik);
		korisnik.setOsoba(this);

		return korisnik;
	}

	public Korisnik removeKorisnik(Korisnik korisnik) {
		getKorisniks().remove(korisnik);
		korisnik.setOsoba(null);

		return korisnik;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}