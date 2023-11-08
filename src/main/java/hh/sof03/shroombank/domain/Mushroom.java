package hh.sof03.shroombank.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity(name="mushrooms")
public class Mushroom {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
<<<<<<< HEAD
	@NotBlank(message = "Binomen cannot be left blank")
=======
>>>>>>> eef534f6494775a0aa6d52b4b702ec59603dccef
	private String binomen; //fancier word scientific name
	private String edible;
	private int taste;
	
	public Mushroom(long id, String name, String binomen, String edible, int taste) {
		super();
		this.id = id;
		this.name = name;
		this.binomen = binomen;
		this.edible = edible;
		this.taste = taste;
	}
	public Mushroom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public int getTaste() {
		return taste;
	}
	public void setTaste(int taste) {
		this.taste = taste;
	}
	@Override
	public String toString() {
		return "Mushroom [id=" + id + ", name=" + name + ", binomen=" + binomen + ", edible=" + edible + ", taste="
				+ taste + "]";
	}

}
