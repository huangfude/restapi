package cn.ffcs.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User implements Serializable {  

	/**
	 * 
	 */
	private static final long serialVersionUID = -3076308822628053067L;
	
	private String name;  
    private String password;
    private int status;
    
    private List<Role> roles;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}  
    
	
}  
