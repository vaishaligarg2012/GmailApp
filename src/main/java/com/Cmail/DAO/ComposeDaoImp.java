package com.Cmail.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.Cmail.ConnectionConfig.DBConfig;
import com.Cmail.Model.ComposeMail;

public class ComposeDaoImp implements ComposeDAO{
	Random rand = new Random();

	
	public boolean createCompose(ComposeMail user, String email) {
		// TODO Auto-generated method stub
		try {
			int  n = rand.nextInt(50) + 1;
			Connection conn=DBConfig.getConnection();
			PreparedStatement pr=conn.prepareStatement("insert into MAILTABLE values(?,?,?,?,?,?)");
		 	pr.setString(1,"some"+n+"@gmail.com");
			pr.setString(2, user.getTo());
            pr.setString(3, email);
            pr.setString(4, user.getSubject());
            pr.setString(5, user.getMsg());
            pr.setString(6, user.getCc());
            
			
            int i=pr.executeUpdate();
            
            System.out.println("compose check "+i);
             if(i==1) {
            	 return true;
             }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;

	}

	public List<ComposeMail> details(String email) {
		// TODO Auto-generated method stub
		List<ComposeMail> list=new ArrayList<ComposeMail>();

		try {
			Connection conn=DBConfig.getConnection();
		
			PreparedStatement ps=conn.prepareStatement("Select * From MAILTABLE where emailid=?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();	
			System.out.println("Sent email check "+rs);
			while(rs.next()){
				
				String emailId=rs.getString(1);
				String to=rs.getString(2);
			//	String from1 =rs.getString(3);
				String sub=rs.getString(4);
				String msg=rs.getString(5);
				String cc=rs.getString(6);
				System.out.println("email " +emailId);

				ComposeMail obj=new ComposeMail();
				obj.setTo(to);
				obj.setMsg(msg);
				obj.setCc(cc);
				obj.setSubject(sub);
	            obj.setId(emailId);
				list.add(obj);
				
				
			}
			System.out.println("List " +list);


		}catch(Exception e) {e.printStackTrace();}
		return list;
	}

	public  List<ComposeMail> viewAllSentMail(String email) {
		// TODO Auto-generated method stub
		List<ComposeMail> list=new ArrayList<ComposeMail>();

		try {
			Connection conn=DBConfig.getConnection();
		
			PreparedStatement ps=conn.prepareStatement("Select * From MAILTABLE where from1=?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();	
			System.out.println("Sent email check "+rs);
			while(rs.next()){
				
				String emailId=rs.getString(1);
				String to=rs.getString(2);
			//	String from1 =rs.getString(3);
				String sub=rs.getString(4);
				String msg=rs.getString(5);
				String cc=rs.getString(6);
				System.out.println("email " +emailId);

				ComposeMail obj=new ComposeMail();
				obj.setTo(to);
				obj.setMsg(msg);
				obj.setCc(cc);
				obj.setSubject(sub);
	            obj.setId(emailId);
				list.add(obj);
				
				
			}
			System.out.println("List " +list);


		}catch(Exception e) {e.printStackTrace();}
		return list;
		}

	public List<ComposeMail> viewAllMails() {
		// TODO Auto-generated method stub
		List<ComposeMail> list=new ArrayList<ComposeMail>();

		try {
			Connection conn=DBConfig.getConnection();
		
			PreparedStatement ps=conn.prepareStatement("Select * From MAILTABLE");
		;
			ResultSet rs=ps.executeQuery();	
			System.out.println("Sent email check "+rs);
			while(rs.next()){
				
				String emailId=rs.getString(1);
				String to=rs.getString(2);
				//String from1 =rs.getString(3);
				String sub=rs.getString(4);
				String msg=rs.getString(5);
				String cc=rs.getString(6);
				System.out.println("email " +emailId);

				ComposeMail obj=new ComposeMail();
				obj.setTo(to);
				obj.setMsg(msg);
				obj.setCc(cc);
				obj.setId(emailId);
				obj.setSubject(sub);
				list.add(obj);
				
				
			}
			System.out.println("List " +list);


		}catch(Exception e) {e.printStackTrace();}

		return list;
	}

}
