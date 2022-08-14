package domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	private String username;
	private String password;
	private String role;
	
//	@OneToMany(mappedBy = "voteID")
//	private final Set<Vote> votes = new HashSet<>();
	
	protected User() {
	}
	
	public User(String username, String password, String role) {
		setUsername(username);
		setPassword(password);
		setRole(role);
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
//	public void addVote(Vote v) {
//		votes.add(v);
//	}
//	
//	public Vote getVote() {
//		return null;
//	}
	
	
	
	
}
