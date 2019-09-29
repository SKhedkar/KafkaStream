package com.infy.accountPublisher.entity;

public class Account {

	private int account_id;
	private int acc_bill;

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getAcc_bill() {
		return acc_bill;
	}

	public void setAcc_bill(int acc_bill) {
		this.acc_bill = acc_bill;
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", acc_bill=" + acc_bill + "]";
	}

}
