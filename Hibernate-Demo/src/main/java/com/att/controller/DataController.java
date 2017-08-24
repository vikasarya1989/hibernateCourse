package com.att.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.att.hibernate.util.MethodUtils;
import com.att.main.pojos.Account;
import com.att.main.pojos.Bank;
import com.att.main.pojos.Budget;
import com.att.main.pojos.Credential;
import com.att.main.pojos.Person;
import com.att.main.pojos.Sampleuser;
import com.att.main.pojos.User;
import com.att.main.pojos.UserAddress;
import com.att.main.pojos.Transaction;
import com.att.mservices.dao.IBankDao;
import com.att.mservices.dao.OracleDaoService;

@Controller
public class DataController {
	
	private IBankDao bankDaoService;
	
	@Autowired
	public void setBankDaoService(IBankDao bankDaoService) {
		this.bankDaoService = bankDaoService;
	}
	
	private OracleDaoService oracleDaoService;
	
	@Autowired
	public void setOracleDaoService(OracleDaoService oracleDaoService) {
		this.oracleDaoService = oracleDaoService;
	}
	
	@RequestMapping(value="/getAllPersonDetails")
	@ResponseBody
	public List<Person> getAllPersonDetails() {
		return oracleDaoService.getAllPersonDetails();
	}
	
	@RequestMapping(value="/getBankDetails")
	@ResponseBody
	public List<Bank> getAllBankDetails() {
		return bankDaoService.getAllBankDetails();
	}
	
	@RequestMapping(value="/getBankDetailsAsMap")
	@ResponseBody
	public Map<String, String> getBankDetailsAsMap() {
		return bankDaoService.getBankDetailsAsMap();
	}
	
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON)
	public void adduser(@RequestBody User user) {
		bankDaoService.adduser(user);
	}
	
	@RequestMapping(value="/addSampleUser", method=RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON)
	public void shoeUser(@RequestBody Sampleuser user) {
		bankDaoService.addSampleuser(user);
		
	}
	
	//OneToMany Unidirectional
	@RequestMapping(value="/addAccountAndTxsObj")
	@ResponseBody
	public String addAccountAndTxsObj() {
		Account account = getAccountFieldDataOne();
		Transaction beltPurchase = getbeltPurchaseTx();
		Transaction shoePurchase = getshoePurchaseTx();
		account.getTransactions().add(beltPurchase);
		account.getTransactions().add(shoePurchase);
		bankDaoService.addAccountAndTxsObj(account);
		return "addAccountAndTxsObj";
	}
	
	//OneToMany Bidirectional
	@RequestMapping(value="/addAccountTxObj")
	@ResponseBody
	public String addAccountTxObj() {
		Account account = getAccountFieldDataOne();
		account.getTransactions().add(getbeltPurchaseTx(account));
		account.getTransactions().add(getshoePurchaseTx(account));
		bankDaoService.addAccountTxObj(account);
		return "addAccountTxObj";
	}
	
	//JoinTable
	@RequestMapping(value="/addBudgetTransactionObj")
	@ResponseBody
	public String addBudgetTransactionObj() {
		
		Account account = getAccountFieldDataOne();
		Budget budget = new Budget();
		budget.setGoalAmount(new BigDecimal("1000.00"));
		budget.setName("Insurance Policy");
		budget.setPeriod("12 Months");
		
		budget.getTransactions().add(getbeltPurchaseTx(account));
		budget.getTransactions().add(getshoePurchaseTx(account));
		
		bankDaoService.addbudgetTransactionObj(budget);
		return "addBudgetTransactionObj";
	}
	
	//ManyToMany-Unidirectional with source entity as Account
	@RequestMapping(value="/addUsersAndAccounts")
	@ResponseBody
	public String addUsersAndAccountsTxnObj() {
		Account account1 = getAccountFieldDataOne();
		Account account2 = getAccountFieldDataTwo();
		
		User user1 = getUserDataOne();
		User user2 = getUserDataTwo();
		
		account1.getUsers().add(user1);
		account2.getUsers().add(user2);
		
		List<Account> accountsToBeSaved = new ArrayList<Account>();
		accountsToBeSaved.add(account1);
		accountsToBeSaved.add(account2);
		bankDaoService.addAccountsAndUsers(accountsToBeSaved);
		
		return "addUsersAndAccountsTxnObj";
	}
	
	//ManyToMany Bidirectional with source Entity as user
	@RequestMapping(value="/addAccountsToUser")
	@ResponseBody
	public String addAccountsToUser() {
		Account account1 = MethodUtils.getAccountFieldDataOne();
		Account account2 = MethodUtils.getAccountFieldDataTwo();
		
		User user1 = MethodUtils.getUserDataOne();
		User user2 = MethodUtils.getUserDataTwo();
		
		account1.getUsers().add(user1);
		account1.getUsers().add(user2);
		account2.getUsers().add(user2);
		account2.getUsers().add(user1);
		
		user1.getAccounts().add(account1);
		user1.getAccounts().add(account2);
		user2.getAccounts().add(account2);
		user2.getAccounts().add(account1);
		
		List<User> usersToBeSaved = new ArrayList<User>();
		usersToBeSaved.add(user1);
		usersToBeSaved.add(user2);
		
		bankDaoService.addAccounsToUsers(usersToBeSaved);
		return "addAccountsToUser";
	}
	
	@RequestMapping(value="/addCredentialForUser")
	@ResponseBody
	public String addCredentialForUser() {
		User user = new User();
		setUserData(user);
		Credential credential = new Credential();
		credential.setUserName("myUserName");
		credential.setPassword("myPassword");
		credential.setUser(user);
		bankDaoService.addCredentialForUser(credential);
		return "credentialUserObj";
	}
	
	@RequestMapping(value="/addUserAddressObj")
	@ResponseBody
	public String addUserAddressObj() {
		UserAddress userAddress1 = new UserAddress();
		setAddressOne(userAddress1);
		bankDaoService.addUserAddressObj(userAddress1);
		return "UserAddressObjText";
	}
	
	@RequestMapping(value="/addUserObj")
	@ResponseBody
	public String returnUserObjText() {
		Date date =  new Date();
		User user = new User();
		UserAddress address1 = new UserAddress();
		UserAddress address2 = new UserAddress();
		setAddressOne(address1);
		setAddressTwo(address2);
		user.getUserAddress().add(address1);
		user.getUserAddress().add(address2);
		setUserData(user);
		bankDaoService.adduser(user);
		return "UserObjText";
	}
	
	@RequestMapping(value="/addBankObj")
	@ResponseBody
	public String addBankObj() {
		Bank bank = new Bank();
		bank.setName("Bank of America");
		bank.setAddressLineOne("44 Green Street");
		bank.setAddressLineTwo("Suite 89");
		bank.setAddresType("Secondary");
		bank.setCity("Wood Bridge");
		bank.setIsInternational(1);
		bank.setCreatedBy("President");
		bank.setCreatedDate(new Date());
		bank.setLastUpdateby("vamsi");
		bank.setLastUpdatedDate(new Date());
		bank.setState("NJ");
		bank.setZipcode("01133");
		bank.getContactsList().put("Manager", "Rodney Lew");
		bank.getContactsList().put("Teller", "Pramendra Tiwari");
		bankDaoService.addBank(bank);
		return "BankObjText";
	}
	
	
	public static void setUserData(User user) {
		user.setuserId(5L);
		user.setFirstName("SuperUserOne");
		user.setLastName("SuperUserOne");
		user.setBirthDate(new Date());
		user.setEmailId("su.su@gmail.com");
		user.setLastUpdatedBy("SU");
		user.setLastUpdated(new Date());
		user.setCreatedBy("SU");
		user.setCreatedDate(new Date());
	}
	
	
	public User getUserDataOne() {
		User user = new User();
		user.setuserId(5L);
		user.setFirstName("SuperUserOne");
		user.setLastName("SuperUserOne");
		user.setBirthDate(new Date());
		user.setEmailId("su.su@gmail.com");
		user.setLastUpdatedBy("SU");
		user.setLastUpdated(new Date());
		user.setCreatedBy("SU");
		user.setCreatedDate(new Date());
		return user;
	}
	
	public User getUserDataTwo() {
		User user = new User();
		user.setuserId(6L);
		user.setFirstName("SuperuserTwo");
		user.setLastName("SuperuserTwo");
		user.setBirthDate(new Date());
		user.setEmailId("su2.su2@gmail.com");
		user.setLastUpdatedBy("SU2");
		user.setLastUpdated(new Date());
		user.setCreatedBy("SU2");
		user.setCreatedDate(new Date());
		return user;
	}
	
	public static void setAddressOne(UserAddress address1) {
		address1.setUserAddressLineOne("56 Atherton Drive");
		address1.setUserAddressLineTwo("Apartment 2");
		address1.setCity("Exton");
		address1.setState("PA");
		address1.setZipcode("19351");
	}
	
	public static void setAddressTwo(UserAddress address2) {
		address2.setUserAddressLineOne("2017 E genesse st");
		address2.setUserAddressLineTwo("Apartment D");
		address2.setCity("Syracuse");
		address2.setState("NY");
		address2.setZipcode("13210");
	}
	
	public Account getAccountFieldDataOne() {
		Account account = new Account();
		account.setInitialBalance(new BigDecimal("1000.00"));
		account.setCurrentBalance(new BigDecimal("991.00"));
		account.setCreatedBy("Peterson");
		account.setCreatedDate(new Date());
		account.setLastupdatedBy("Peterson");
		account.setLasUpdatedDate(new Date());
		account.setOpenDate(new Date());
		account.setCloseDate(new Date());
		account.setName("Savings Account");
		return account;
	}
	
	public Account getAccountFieldDataTwo() {
		Account account = new Account();
		account.setInitialBalance(new BigDecimal("1100.00"));
		account.setCurrentBalance(new BigDecimal("891.00"));
		account.setCreatedBy("Michael");
		account.setCreatedDate(new Date());
		account.setLastupdatedBy("Scofield");
		account.setLasUpdatedDate(new Date());
		account.setOpenDate(new Date());
		account.setCloseDate(new Date());
		account.setName("Savings Account");
		return account;
	}
	
	
	public Transaction getbeltPurchaseTx() {
		Transaction beltPurchase = new Transaction();
		beltPurchase.setTitle("Dress Belt");
		beltPurchase.setAmount(new BigDecimal("50.00"));
		beltPurchase.setClosingBalance(new BigDecimal("0.00"));
		beltPurchase.setInitialBalance(new BigDecimal("0.00"));
		beltPurchase.setCreatedBy("Kevin");
		beltPurchase.setCreatedDate(new Date());
		beltPurchase.setLastUpdatedby("Kevin");
		beltPurchase.setLastUpdatedDate(new Date());
		beltPurchase.setNotes("Purchased Dress Belt");
		beltPurchase.setTransactionType("Debit");
		return beltPurchase;
	}
	
	public Transaction getshoePurchaseTx() {
		Transaction shoePurchase = new Transaction();
		shoePurchase.setTitle("Dress Shoes");
		shoePurchase.setAmount(new BigDecimal("10.00"));
		shoePurchase.setClosingBalance(new BigDecimal("20.00"));
		shoePurchase.setInitialBalance(new BigDecimal("40.00"));
		shoePurchase.setCreatedBy("Kevin");
		shoePurchase.setCreatedDate(new Date());
		shoePurchase.setLastUpdatedby("Kevin");
		shoePurchase.setLastUpdatedDate(new Date());
		shoePurchase.setNotes("Purchased Dress Belt");
		shoePurchase.setTransactionType("Credit");
		return shoePurchase;
	}
	
	public Transaction getbeltPurchaseTx(Account account) {
		Transaction beltPurchase = new Transaction();
		beltPurchase.setAccount(account);
		beltPurchase.setTitle("Dress Belt");
		beltPurchase.setAmount(new BigDecimal("50.00"));
		beltPurchase.setClosingBalance(new BigDecimal("0.00"));
		beltPurchase.setInitialBalance(new BigDecimal("0.00"));
		beltPurchase.setCreatedBy("Kevin");
		beltPurchase.setCreatedDate(new Date());
		beltPurchase.setLastUpdatedby("Kevin");
		beltPurchase.setLastUpdatedDate(new Date());
		beltPurchase.setNotes("Many To One Bidirectional Belt Purchase");
		beltPurchase.setTransactionType("Debit");
		return beltPurchase;
	}
	
	public Transaction getshoePurchaseTx(Account account) {
		Transaction shoePurchase = new Transaction();
		shoePurchase.setAccount(account);
		shoePurchase.setTitle("Dress Shoes");
		shoePurchase.setAmount(new BigDecimal("10.00"));
		shoePurchase.setClosingBalance(new BigDecimal("20.00"));
		shoePurchase.setInitialBalance(new BigDecimal("40.00"));
		shoePurchase.setCreatedBy("Kevin");
		shoePurchase.setCreatedDate(new Date());
		shoePurchase.setLastUpdatedby("Kevin");
		shoePurchase.setLastUpdatedDate(new Date());
		shoePurchase.setNotes("Many To One Bidirectional Shoe Purchase");
		shoePurchase.setTransactionType("Credit");
		return shoePurchase;
	}
}
