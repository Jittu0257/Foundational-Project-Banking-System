package com.revature.service;

import java.util.ArrayList;

import com.revature.dao.RevatureDao;
import com.revature.model.Revature;

public class RevatureService {
	public int createAccount(Revature re1)
	{
		RevatureDao rd = new RevatureDao();
		int result = rd.creation(re1);
		return result;
	}
	public ArrayList<Revature> balanceEnquiry(Revature re2)
	{
		RevatureDao rd1 = new RevatureDao();
		ArrayList<Revature> rl = rd1.balance(re2);
		return rl;
	}
	public int withDrawl(Revature rs1) {
		RevatureDao rd2 = new RevatureDao();
		int result2 = rd2.withDrawlAmount(rs1);
		return result2;
	}
	public int deposit(Revature rs2) {
		RevatureDao rd3 = new RevatureDao();
		int result3 = rd3.depositAmount(rs2);
		return result3;
	}
	public int transfer(Revature r4) {
		RevatureDao rd4 = new RevatureDao();
		int result3 = rd4.depositAmount(r4);
        return result3;
	}
}
	
	



