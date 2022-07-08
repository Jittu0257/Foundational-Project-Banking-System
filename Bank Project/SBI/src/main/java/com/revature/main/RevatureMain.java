 package com.revature.main;

 import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.RevatureDao;
import com.revature.model.Revature;
import com.revature.service.RevatureService;

public class RevatureMain 
{
	private static final Logger log = LogManager.getLogger(RevatureMain.class);
	public void Register()
	{ 
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter your Name:");
		String customerName = sc1.next();
		System.out.println("Enter IFSC code:");
		String code =sc1.next();
		sc1.next();
		System.out.println("Enter Intial amount to set your bank account:");
		int balance = sc1.nextInt();
		Revature r=new Revature();
		r.setName(customerName);
		r.setIfscCode(code);
		r.setBalance(balance);
		RevatureService rs1 = new RevatureService();
		int result = rs1.createAccount(r);
		if(result!=0)
		{
			System.out.println("Account Created Successfully");
		}
		else
		{
			System.out.println("Account creation failed....... ");
		}	
		sc1.close();
	}
	public void checkBalance()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Account Number");
		Long acNo = sc.nextLong();
		Revature r2 = new Revature();
		r2.setAccountNumber(acNo);
		RevatureService rs2 = new RevatureService();
		ArrayList<Revature> rlist = rs2.balanceEnquiry(r2);
		//System.out.println("CustomerName AccountNumber Balance");
		//System.out.println("****");
		//rlist.forEach((n)->System.out.println(n.toString()));
		for(Revature n:rlist)
		{
			System.out.println(n.toString());
			System.out.println(n.getName()+" "+n.getAccountNumber()+" "+n.getBalance()+" ");
		}
		sc.close();
	}
	public void withdraw()
	{
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter your Account Number:");
		Long accNo = sc.nextLong();
		System.out.println("Enter withdrawl Amount:");
		int amount = sc.nextInt();
		Revature r3 = new Revature();
		r3.setBalance(amount);
		r3.setAccountNumber(accNo);
		RevatureService rs3 = new RevatureService();
		int result1 = rs3.withDrawl(r3);
		if(result1!=0)
		{
			System.out.println("Withdrawl Transaction Successfull");
		}
		else
		{
			System.out.println("withdrawl Transaction fails");
		}
		sc.close();
	}
	public void deposit()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Account Number:");
		Long accNo2 = sc.nextLong();
		System.out.println("Enter your Deposit Amount:");
		int amount2 = sc.nextInt();
		Revature r4 = new Revature();
		r4.setBalance(amount2);
		r4.setAccountNumber(accNo2);
		RevatureService rs4 = new RevatureService();
		int result2 = rs4.deposit(r4);
		if(result2!=0)
		{
			log.info("deposit succesful");
			System.out.println("Deposit Transaction Successfull");
		}
		else
		{
			System.out.println("Deposit Transaction fails");
		}
		sc.close();
	
	}
	public void transfer() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter debit Account Number:");
		Long accNo = sc.nextLong();
		System.out.println("Enter debit Amount:");
		int amount = sc.nextInt();
		Revature r3 = new Revature();
		r3.setBalance(amount);
		r3.setAccountNumber(accNo);
		System.out.println("Enter credit Account Number:");
		Long accNo2 = sc.nextLong();
		int amount2 = amount;
		Revature r4 = new Revature();
		r4.getBalance();
		r4.getAccountNumber();
		RevatureService rs4 = new RevatureService();
		int result2 = rs4.transfer(r4);
		if(result2!=0)
		{
			
			System.out.println(" Transaction Successfull");
		}
		else
		{
			System.out.println(" Transaction fails");
		}
		sc.close();

		
	}
	public void running()
	{
		RevatureDao d = new RevatureDao();
		d.runningAccount();
	}
	public void viewDetails()
	{
		checkBalance();
	}
	public static void main(String[] args)
	{
		RevatureMain rm = new RevatureMain();
		Scanner sc = new Scanner(System.in);                                         
		System.out.println("Register or Login as a Customer (or) and login as a Employee:");                      
		System.out.println("1.Customer");                                             
		System.out.println("2.Employee");
		int choose = sc.nextInt();
		switch(choose)
		{
			case 1:
				log.info("selected as customer");
				System.out.println("Please Select your option \n1.Create new Account(Register)\n2.Check Balance \n3.WithDrawl  \n4.Deposit  \n5.transfer");
				int option = sc.nextInt();
				switch(option)
				{
					case 1: 
						rm.Register();
						break;
						
					case 2:
						rm.checkBalance();
						break;
						
					case 3:
						rm.withdraw();
						break;
						
					case 4:
						rm.deposit();
					    break;
					    
					case 5:
						rm.transfer();
						break;
						
					default:
						System.out.println("Choose valid option");
						break;
				}
				break;
			case 2 :
				String ps = "john2773";
				int id = 91210;
				System.out.println("Enter Your ID:");
				int empId = sc.nextInt();
				System.out.println("Enter your password:");
				sc.nextLine();
				String pswd = sc.nextLine();
				if(id == empId && ps.equals(pswd))
				{
					System.out.println("Enter your choice:");
					System.out.println("1.Running customer accounts\n2.View customer bank Deatails");
					int opt = sc.nextInt();
					switch(opt)
					{
						case 1:
							rm.running();
							break;
						case 2:
							rm.viewDetails();
							break;
					}
				}
				else
				{
					System.out.println("Enter coorect credentials"); 
				} 
				break;
			default:
				System.out.println("Choose the Correct option");
				break;
		}
		sc.close();
	}
	
	
}