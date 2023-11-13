package hh.sof03.shroombank.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity(name="users")
public class User {
	// Determining constraints for User data fields. All fields are required, id cannot change and user name must be unique
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid", nullable = false, updatable = false)
	private Long userid;
	@Column(name = "username", nullable = false, unique = true)
	@NotBlank(message = "Username cannot be empty!")
	private String username;
	@Column(name = "hash", nullable = false)
	@NotBlank(message = "Password cannot be empty!")
	private String hash;
	@Column(name = "role", nullable = false)
	private String role;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private List<Collection> collections;
	
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
	public List<Collection> getCollections() {
		return collections;
	}
	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", userName=" + username + ", hash=" + hash + ", role=" + role + "]";
	}
}