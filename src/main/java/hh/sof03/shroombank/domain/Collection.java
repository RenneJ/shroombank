package hh.sof03.shroombank.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="collections")
public class Collection {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long collectionid;
	@ManyToOne
	@JoinColumn(name="mushroomid")
	private Mushroom mushroom;
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	private int quantity;
	private Date date;
	private String location;
	
	public Collection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Collection(Mushroom mushroom, User user, int quantity, Date date, String location) {
		super();
		this.mushroom = mushroom;
		this.user = user;
		this.quantity = quantity;
		this.date = date;
		this.location = location;
	}
	public long getCollectionid() {
		return collectionid;
	}
	public void setCollectionid(long collectionid) {
		this.collectionid = collectionid;
	}
	public Mushroom getMushroom() {
		return mushroom;
	}
	public void setMushroom(Mushroom mushroom) {
		this.mushroom = mushroom;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Collection [collectionid=" + collectionid + ", mushroom=" + mushroom + ", user=" + user + ", quantity="
				+ quantity + ", date=" + date + ", location=" + location + "]";
	}
}
