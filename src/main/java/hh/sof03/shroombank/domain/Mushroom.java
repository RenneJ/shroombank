package hh.sof03.shroombank.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mushroom {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String edible;
	private String taste;
	
	public Mushroom(long id, String name, String edible, String taste) {
		super();
		this.id = id;
		this.name = name;
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
	public String getEdible() {
		return edible;
	}
	public void setEdible(String edible) {
		this.edible = edible;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	@Override
	public String toString() {
		return "Mushroom [id=" + id + ", name=" + name + ", edible=" + edible + ", taste=" + taste + "]";
	}
}
