package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonIgnore;

import be.vdab.valueobjects.Adres;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "filialen")
public class Filiaal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@Length(min = 1, max = 50)
	@SafeHtml
	private String naam;
	@XmlElement
	@Valid
	@Embedded
	private Adres adres;
	@DateTimeFormat(style = "S-")
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date inGebruikName;
	@NumberFormat(style = Style.NUMBER)
	@NotNull
	@Min(0)
	@Digits(integer = 10, fraction = 2)
	private BigDecimal waardeGebouw;
	private boolean hoofdFiliaal;
	@XmlTransient
	@JsonIgnore
	@OneToMany(mappedBy = "filiaal")
	private Set<Werknemer> werknemers;
	
	public Filiaal() {}
	
	public Filiaal(String naam,
			boolean hoofdFiliaal,
			BigDecimal waardeGebouw,
			Date inGebruikName,
			Adres adres) {
		this.naam = naam;
		this.hoofdFiliaal = hoofdFiliaal;
		this.waardeGebouw = waardeGebouw;
		this.inGebruikName = inGebruikName;
		this.adres = adres;
	}
	
	public Filiaal(long id, String naam, boolean hoofdFiliaal,
			BigDecimal waardeGebouw, Date inGebruikName, Adres adres) {
		this(naam, hoofdFiliaal, waardeGebouw, inGebruikName, adres);
		this.id = id;
	}


	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public boolean isHoofdFiliaal() {
		return hoofdFiliaal;
	}

	public BigDecimal getWaardeGebouw() {
		return waardeGebouw;
	}

	public Date getInGebruikName() {
		return inGebruikName;
	}

	public Adres getAdres() {
		return adres;
	}

	public Set<Werknemer> getWerknemers() {
		return Collections.unmodifiableSet(werknemers);
	}
	
	public void afschrijven() {
		this.waardeGebouw = BigDecimal.ZERO;
	}

	
}
