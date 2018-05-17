package dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import model.Student;

/**
Created By Marko
*/

public class StudentDTO {
	
	private int id;
	
	@Size(min = 2)
	@NotEmpty
	@NotNull
	private String ime;
	
	@Size(min = 2)
	@NotEmpty
	@NotNull
	private String prezime;
	
	@NotNull
	private String pol;
	
	@NotNull
	private Date godRodjenja;
	
	@NotNull
	private String sport;
	
	@NotNull
	private String hobi;
	
	@NotNull
	private int index;

	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentDTO(Student student) {
		setId(student.getOsobaId());
		setIme(student.getOsoba().getIme());
		setPrezime(student.getOsoba().getPrezime());
		setPol(student.getOsoba().getPol());
		setGodRodjenja(student.getOsoba().getGodRodjenja());
		setSport(student.getSport());
		setHobi(student.getHobi());
		setIndex(student.getIndex());
	}

	public StudentDTO(int id, String ime, String prezime, String pol, Date godRodjenja, String sport, String hobi,
			int index) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.pol = pol;
		this.godRodjenja = godRodjenja;
		this.sport = sport;
		this.hobi = hobi;
		this.index = index;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public Date getGodRodjenja() {
		return godRodjenja;
	}

	public void setGodRodjenja(Date godRodjenja) {
		this.godRodjenja = godRodjenja;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getHobi() {
		return hobi;
	}

	public void setHobi(String hobi) {
		this.hobi = hobi;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", pol=" + pol + ", godRodjenja="
				+ godRodjenja + ", sport=" + sport + ", hobi=" + hobi + ", index=" + index + "]";
	}
	
}
