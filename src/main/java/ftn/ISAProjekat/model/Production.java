package ftn.ISAProjekat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Production implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String actors;
	
	@Column(nullable = false)
	private String genre;
	
	@Column(nullable = false)
	private String nameOfDirector;

	@Column(nullable = false)
	private float duration;
	
	@Column(nullable = false)
	private int avrageRating;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private boolean isMovie;
	
	@Column(nullable = false)
	private int productionRate;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="production") 
	private List<Repertoire> repertoires;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="production") 
	private List<ProductionRating> productionRatings;
	
	public Production() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getNameOfDirector() {
		return nameOfDirector;
	}

	public void setNameOfDirector(String nameOfDirector) {
		this.nameOfDirector = nameOfDirector;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public int getAvrageRating() {
		return avrageRating;
	}

	public void setAvrageRating(int avrageRating) {
		this.avrageRating = avrageRating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isMovie() {
		return isMovie;
	}

	public void setMovie(boolean isMovie) {
		this.isMovie = isMovie;
	}

	public int getProductionRate() {
		return productionRate;
	}

	public void setProductionRate(int productionRate) {
		this.productionRate = productionRate;
	}

	public List<Repertoire> getRepertoires() {
		return repertoires;
	}

	public void setRepertoires(List<Repertoire> repertoires) {
		this.repertoires = repertoires;
	}
	
}
