package com.att.main.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CREDENTIAL")
public class Credential {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CREDENTIAL_ID")
	private Long credentialId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")
	public User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Column(name="USERNAME")
	private String userName;
	
	public Long getCredentialId() {
		return credentialId;
	}
	public void setCredentialId(Long credentialId) {
		this.credentialId = credentialId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="PASSWORD")
	private String password;
	
}
