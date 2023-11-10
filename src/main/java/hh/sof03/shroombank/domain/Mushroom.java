package hh.sof03.shroombank.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity(name="mushrooms")
public class Mushroom {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long mushroomid;
	private String name;
	@NotBlank(message = "Binomen cannot be left blank")
	private String binomen; //fancier word scientific name
	private String edible;
	private double taste;
	@OneToMany(mappedBy="mushroom")
	private List<Collection> collections;
	
	public Mushroom(long mushroomid, String name, String binomen, String edible, double taste) {
		super();
		this.mushroomid = mushroomid;
		this.name = name;
		this.binomen = binomen;
		this.edible = edible;
		this.taste = taste;
	}
	public Mushroom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getMushroomid() {
		return mushroomid;
	}
	public void setMushroomid(long mushroomid) {
		this.mushroomid = mushroomid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBinomen() {
		return binomen;
	}
	public void setBinomen(String binomen) {
		this.binomen = binomen;
	}
	public String getEdible() {
		return edible;
	}
	public void setEdible(String edible) {
		this.edible = edible;
	}
	public double getTaste() {
		return taste;
	}
	public void setTaste(double taste) {
		this.taste = taste;
	}
	public List<Collection> getCollections() {
		return collections;
	}
	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}
	@Override
	public String toString() {
		return "Mushroom [id=" + mushroomid + ", name=" + name + ", binomen=" + binomen + ", edible=" + edible + ", taste="
				+ taste + "]";
	}

}
