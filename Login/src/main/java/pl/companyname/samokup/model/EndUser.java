package pl.companyname.samokup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
 
/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author rkuklinski
 *
 */
@Entity
@Table(name="USERS")
@SecondaryTable(name="USERPASSWORDS")
public class EndUser {
 
    @Id    
    private String email;
     
    private String username;
     
    @Column(table="USERPASSWORDS")
    private String password;
 
    public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	private String role = "Admin";
    
    public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
    public String toString(){
        return "email="+email+", name="+username+", password="+password;
    }
}
