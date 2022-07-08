package com.revature.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.dao.RevatureDao;
import com.revature.model.Revature;


public class RevatureServiceTest {
	@Test
	public void testDepositAmount() {
		RevatureDao bd =new RevatureDao();
		Revature b = new Revature();
		b.setName("Devi");
		b.setAccountNumber((long) 2);
		b.setIfscCode("sbin000689");
		b.setBalance(500);
		int status=bd.depositAmount(b);
		assertEquals(1,status);
	}
	
	
}



	
	
	
	
	


