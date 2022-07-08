package com.revature.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.revature.main.RevatureMain;
import com.revature.model.Revature;

public class RevatureDao 
{
		public int creation(Revature details)
		{
			String url="jdbc:mysql://localhost:3306/revature";
			String user="root";
			String password="Appu7christ@";
			String sql="INSERT INTO revaturebank VALUES(?,?,?,?)";
			int status=0;
			try {
				Connection con=DriverManager.getConnection(url, user, password);
				PreparedStatement psmt=con.prepareStatement(sql);
				psmt.setString(1,details.getName());
				psmt.setNull(2, Types.NULL);
				psmt.setString(3, details.getIfscCode());
				psmt.setInt(4, details.getBalance());
				status = psmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;
		}
		public ArrayList<Revature> balance(Revature bal)
		{
			String url="jdbc:mysql://localhost:3306/revature";
			String user="root";
			String password="Appu7christ@";
			Long s = bal.getAccountNumber();
			String sql = "SELECT * FROM revaturebank where accountNumber = '"+s+"'";
			ArrayList<Revature> list=new ArrayList<Revature>();
			try 
			{
				Connection con=DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt=con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) 
				{
					Revature revature =new  Revature();
					revature.setName(rs.getString(1));
					revature.setAccountNumber(rs.getLong(2));
					revature.setIfscCode(rs.getString(3));
					revature.setBalance(rs.getInt(4));
					list.add(revature);
				}
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		public int withDrawlAmount(Revature w) {
			String url="jdbc:mysql://localhost:3306/revature";
			String user="root";
			String password="Appu7christ@";
			int status = 0;
			String sql = "UPDATE revaturebank set balance=balance-'"+w.getBalance()+"' where accountNumber='"+w.getAccountNumber()+"'";
			try {
				Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement();
				status = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return status;
		}
		public int depositAmount(Revature d)
		{
			String url="jdbc:mysql://localhost:3306/revature";
			String user="root";
			String password="Appu7christ@";
			int status = 0;
			String sql = "UPDATE revaturebank set balance=balance+'"+d.getBalance()+"' where accountNumber='"+d.getAccountNumber()+"'";
			try {
				Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement();
				status = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return status;
		}
		public int transfer(RevatureMain f) {
			String url="jdbc:mysql://localhost:3306/revature";
			String user="root";
			String password="Appu7christ@";
			int status = 0;
			String sql = "UPDATE revaturebank set balance=balance-amount from debitAccountNumber where accountNumber=debitAccountNumber";
			try {
				Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement();
				status = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return status;
		}
		public int transfer(Revature f) {
			String url="jdbc:mysql://localhost:3306/revature";
			String user="root";
			String password="Appu7christ@";
			int status = 0;
			String sql = "UPDATE revaturebank set balance=balance+amount from creditAccount	Number where accountNumber=creditAccountNumber ";
			try {
				Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement();
				status = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return status;
		}
			
		
		  public void runningAccount() {
			String url="jdbc:mysql://localhost:3306/revature";
			String user="root";
			String password="Appu7christ@";
			String sql="SELECT accountNumber,name,balance FROM revaturebank where balance<100";
			try {
				Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet re = st.executeQuery();
				while(re.next())
				{
					Long accountNumber= re.getLong(1);
					String name = re.getString(2);
					int balance = re.getInt(3);
					Statement ps = con.createStatement();
					int rs = ps.executeUpdate("DELETE FROM revaturebank WHERE balance="+balance+"");
					if(rs!=0)
					{
					System.out.println("your account is rejected due to less balance:/n AccountNumber Name Balance/n");
					System.out.println(accountNumber+" "+name+" "+balance+" ");
				}
					System.out.println("all are perfect");
				}
			  } 
				catch (SQLException e) {
				// TODO: handle exception
					e.printStackTrace();
			}
	}
	
		}