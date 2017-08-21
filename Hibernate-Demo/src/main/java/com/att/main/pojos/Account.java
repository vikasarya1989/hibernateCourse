package com.att.main.pojos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="ACCOUNT")
public class Account {
	@Id
	@Column(name="ACCOUNT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long accountId;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USER_ACCOUNT", joinColumns=@JoinColumn(name="ACCOUNT_ID"), 
				inverseJoinColumns=@JoinColumn(name="USER_ID"))
	public List<User> users = new ArrayList<User>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="account")
	List<Transaction> transactions = new ArrayList<Transaction>();
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Column(name="BANK_ID")
	private Long bankId;
	
	@Column(name="ACCOUNT_TYPE")
	private String accountType;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="INITIAL_BALANCE")
	private BigDecimal initialBalance;
	
	@Column(name="CURRENT_BALANCE")
	private BigDecimal currentBalance;
	
	@Column(name="OPEN_DATE")
	private Date openDate;
	
	@Column(name="CLOSE_DATE")
	private Date closeDate;
	
	@Column(name="LAST_UPDATED_BY")
	private String lastupdatedBy;
	
	@Column(name="LAST_UPDATED_DATE")
	private Date lasUpdatedDate;
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getBankId() {
		return bankId;
	}
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(BigDecimal initialBalance) {
		this.initialBalance = initialBalance;
	}
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public String getLastupdatedBy() {
		return lastupdatedBy;
	}
	public void setLastupdatedBy(String lastupdatedBy) {
		this.lastupdatedBy = lastupdatedBy;
	}
	public Date getLasUpdatedDate() {
		return lasUpdatedDate;
	}
	public void setLasUpdatedDate(Date lasUpdatedDate) {
		this.lasUpdatedDate = lasUpdatedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
}
