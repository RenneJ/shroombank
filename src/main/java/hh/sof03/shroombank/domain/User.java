package hh.sof03.shroombank.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="users")
public class User {
	// Determining constraints for User data fields. All fields are required, id cannot change and user name must be unique
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid", nullable = false, updatable = false)
	private Long userid;
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	@Column(name = "hash", nullable = false)
	private String hash;
	@Column(name = "role", nullable = false)
	private String role;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String hash, String role) {
		super();
		this.username = username;
		this.hash = hash;
		this.role = role;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}