package com.revature.model;

public class Revature {
	    private String Name;   
	    private Long accountNumber;
	    private String ifscCode;
	    private int balance;
	    
	    public Revature() {
	    	super();
	    }
		public Revature(String name, Long accountNumber, String ifscCode, int balance) {
			super();
			this.Name = name;
			this.accountNumber = accountNumber;
			this.ifscCode = ifscCode;
			this.balance = balance;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public Long getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(Long accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getIfscCode() {
			return ifscCode;
		}
		public void setIfscCode(String ifscCode) {
			this.ifscCode = ifscCode;
		}
		public int getBalance() {
			return balance;
		}
		public void setBalance(int balance) {
			this.balance = balance;
		}
		
}
		